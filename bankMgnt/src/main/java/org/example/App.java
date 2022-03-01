package org.example;

import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        try {
            Scanner sc = new Scanner(System.in);
            EmployeeService employeeService;

            int c;
            System.out.println("Welcome to the INC Bank");
            do {
                System.out.println("1. To Create Account");
                System.out.println("2. To Login to the Account");
                System.out.println("0. Exit");
                System.out.println("Enter the choice: ");
                c = sc.nextInt();
                employeeService = new EmployeeServiceImpl();
                switch(c)
                {
                    case 1:
                        employeeService.createEmployee();
                        break;
                    case 2:
                        System.out.println("Enter the User Id");
                        int id=sc.nextInt();
                        System.out.println("Enter the passcode ");
                        int pass_code=sc.nextInt();
                        employeeService.login(id,pass_code);
                        break;
                    case 0:
                        System.out.println("Byee!! Exiting application");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter a valid Choice");
                        break;
                }

            } while (c != 0);
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }
}
