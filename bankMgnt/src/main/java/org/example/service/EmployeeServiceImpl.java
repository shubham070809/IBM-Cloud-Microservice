package org.example.service;

import org.example.Employee;
import org.example.repo.EmployeeRepository;
import org.example.repo.EmployeeRepositoryImpl;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        employeeRepository=new EmployeeRepositoryImpl();
    }

    @Override
    public void createEmployee() throws SQLException {
        employeeRepository.createEmployee();

    }

    @Override
    public void login(int employeeId, int pass) throws SQLException {
        employeeRepository.login(employeeId,pass);

    }

    @Override
    public void transfer(int employeeId, int amount) throws SQLException {

    }
}
