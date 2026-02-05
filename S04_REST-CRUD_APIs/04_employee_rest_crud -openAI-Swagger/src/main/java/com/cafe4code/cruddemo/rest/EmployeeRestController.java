package com.cafe4code.cruddemo.rest;
import com.cafe4code.cruddemo.entity.Employee;
import com.cafe4code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;
    @Autowired
    public EmployeeRestController(EmployeeService employeeServiceInj, JsonMapper jsonMapperInj){
        this.employeeService = employeeServiceInj;
        this.jsonMapper = jsonMapperInj;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){

        Employee emp = employeeService.findById(id);

        if (emp == null){
            throw new RuntimeException("employee not found -> " + id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){

        emp.setId(null);
        Employee dbEmp = employeeService.save(emp);

        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){

        Employee dbEmp = employeeService.save(emp);

        return dbEmp;
    }

    @PatchMapping("/employees/{id}")
    public Employee patchUpdate(@PathVariable int id, @RequestBody Map<String, Object> jsonEmp){

        Employee tempEmp = employeeService.findById(id);

        if (tempEmp == null){
            throw new RuntimeException("Employee id not found -> " + id);
        }
        if (jsonEmp.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body , delete -> " + jsonEmp.get("id"));
        }

        Employee patchedEmp = jsonMapper.updateValue(tempEmp, jsonEmp);
        Employee dbEmp = employeeService.save(patchedEmp);

        return dbEmp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee tempEmp = employeeService.findById(id);

        if (tempEmp == null){
            throw new RuntimeException("Employee id not found -> " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee is completed !" + id;
    }

}
