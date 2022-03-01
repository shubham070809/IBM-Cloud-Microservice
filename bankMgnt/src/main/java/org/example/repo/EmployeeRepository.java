package org.example.repo;

import org.example.Employee;

import java.sql.SQLException;

public interface EmployeeRepository {

    public void createEmployee() throws SQLException;
    public void login(int employeeId, int pass) throws SQLException;
    public void transfer(int employeeId,int amount)throws SQLException;
}
