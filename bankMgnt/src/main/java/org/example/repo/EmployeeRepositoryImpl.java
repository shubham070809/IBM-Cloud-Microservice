package org.example.repo;

import org.example.Employee;
import org.example.factory.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private MyConnection myConnection;
    private ResultSet resultSet;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private Scanner sc=new Scanner(System.in);

    public EmployeeRepositoryImpl() {
        myConnection=MyConnection.getObject();
        try {
            connection= myConnection.getMyConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEmployee() throws SQLException {
        preparedStatement=connection.prepareStatement("insert into customer(cname,balance,pass_code) values (?,?,?)");
        try
        {
            System.out.println("Enter the unique User Name");
            String name=sc.next();

            System.out.println("Enter the initial deposit");
            int balance=sc.nextInt();

            System.out.println("Enter Unique Integer password");
            int pass_code=sc.nextInt();

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,balance);
            preparedStatement.setInt(3,pass_code);
            int res=preparedStatement.executeUpdate();
            if(res==0)
            {
                System.out.println("Error:: The Account not created.. please try again");
            }
            else
            {
                System.out.println("Account Created!!");
            }


        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void login(int employeeId, int pass) throws SQLException {
        Employee e=findById(employeeId);
        if(e==null || e.getAc_no()!=employeeId || e.getPass_code()!=pass)
        {
            System.out.println("Enter Valid Account Credentials");
            return;
        }
        else
        {
            System.out.println("Successful login!!");
            int c=0;
            try {
                do {
                    System.out.println("1. Enter to get Acc info");
                    System.out.println("2. Enter to transfer money");
                    System.out.println("0. Enter to Logout");

                    System.out.println("Enter the choice");
                    c = sc.nextInt();
                    switch(c)
                    {
                        case 1:
                            System.out.println("The Details for the Employee are");
                            System.out.println(e);
                            break;
                        case 2:
                            System.out.println("Enter the transfer id");
                            int t_id=sc.nextInt();

                            if(findById(t_id)==null)
                            {
                                System.out.println("Error!!! No such account Exists\n Please Enter a valid Account Number");
                            }
                            else {
                                System.out.println("Enter the Amount to be transferred");
                                int t_amt=sc.nextInt();
                                if(t_amt>e.getBalance())
                                {
                                    System.out.println("Enter tranfer amount that is less than equal to your Account Balance");
                                }
                                else
                                {
                                    preparedStatement=connection.prepareStatement("update customer set balance=balance-? where ac_no=?");
                                    preparedStatement.setInt(1,t_amt);
                                    preparedStatement.setInt(2,employeeId);
                                    int res=preparedStatement.executeUpdate();
                                    if(res==0)
                                    {
                                        System.out.println("Amount Not debitted");
                                    }
                                    else
                                    {
                                        System.out.println("Amount successfully debitted");
                                    }

                                    preparedStatement=connection.prepareStatement("update customer set balance=balance+? where ac_no=?");
                                    preparedStatement.setInt(1,t_amt);
                                    preparedStatement.setInt(2,t_id);
                                    res= preparedStatement.executeUpdate();
                                    if(res==0)
                                    {
                                        System.out.println("Amount not creditted");
                                    }
                                    else
                                    {
                                        System.out.println("Amount  creditted");
                                    }
                                    e=findById(employeeId);
                                    System.out.println(e);
                                    Employee ee=findById(t_id);
                                    System.out.println(ee);

                                }
                            }
                            break;
                        case 0:
                            System.out.println("Logging off");
                            System.out.println("Have a nice day");


                    }

                } while (c != 0);
            }
            catch(Exception ee)
            {
                System.out.println(ee.getStackTrace());
            }

        }

    }

    @Override
    public void transfer(int employeeId, int amount) throws SQLException {

    }

    public Employee findById(int id) {
        try {
            preparedStatement = connection.prepareStatement("select * from customer where ac_no=?");
            List<Employee> list = new ArrayList<>();
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));

            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}
