package com.cafe4code.thymeleafdemo.controller;
import com.cafe4code.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${programLanguage}")
    private List<String> programLanguage;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    @GetMapping("/showstudentform")
    public String showForm(Model model){

        Student studentObj = new Student();
        model.addAttribute("student",studentObj);
        model.addAttribute("countries", countries);
        model.addAttribute("programLanguage", programLanguage);
        model.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @PostMapping("processstudent")
    public String processStudent(@ModelAttribute("student") Student studentObj){

        System.out.println("the student name: " + studentObj.getFirstName() + studentObj.getLastName());

        return "confirm-page";
    }

}
