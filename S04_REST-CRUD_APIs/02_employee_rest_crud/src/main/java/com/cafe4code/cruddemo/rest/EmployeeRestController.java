package com.cafe4code.cruddemo.rest;

import com.cafe4code.cruddemo.dao.EmployeeDAO;
import com.cafe4code.cruddemo.entity.Employee;
import com.cafe4code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeServiceInj){
        this.employeeService = employeeServiceInj;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
