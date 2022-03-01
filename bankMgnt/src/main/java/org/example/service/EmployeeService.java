package org.example.service;

import org.example.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public void createEmployee() throws SQLException;
    public void login(int employeeId, int pass) throws SQLException;
    public void transfer(int employeeId,int amount)throws SQLException;
}
