package com.luv2code.springboot.thymeleafdemo.controller;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService2){
        employeeService = employeeService2;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        List<Employee> employeesDb = employeeService.findAll();
        model.addAttribute("employees", employeesDb);

        return "list-employees";
    }

    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int id, Model model){

        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
// deleteEmployee
        return "employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
















}
