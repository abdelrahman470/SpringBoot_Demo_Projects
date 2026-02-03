package com.cafe4code.cruddemo.rest;
import com.cafe4code.cruddemo.entity.Employee;
import com.cafe4code.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
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

}
