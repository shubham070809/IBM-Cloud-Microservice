package org.example.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private DriverManager driverManager=null;
    private Connection connection=null;
    private static MyConnection myConnection;

    private MyConnection()  {

    }


    public static MyConnection getObject()
    {
        if (myConnection==null)
        {
            myConnection=new MyConnection();
        }
        return myConnection;
    }

    public Connection getMyConnection() throws SQLException {
        connection=DriverManager.getConnection("jdbc:mysql://localhost/banking","root","pass@word1");
        return connection;
    }
}
