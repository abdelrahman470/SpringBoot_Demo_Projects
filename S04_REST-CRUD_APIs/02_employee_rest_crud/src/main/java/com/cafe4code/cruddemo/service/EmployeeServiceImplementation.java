package com.cafe4code.cruddemo.service;
import com.cafe4code.cruddemo.dao.EmployeeDAO;
import com.cafe4code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImplementation(EmployeeDAO employeeDAOInj){
        employeeDAO = employeeDAOInj;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
