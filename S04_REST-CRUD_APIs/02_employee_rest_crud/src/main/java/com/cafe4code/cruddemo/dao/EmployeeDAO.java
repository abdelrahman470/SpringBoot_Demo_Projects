package com.cafe4code.cruddemo.dao;
import com.cafe4code.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
