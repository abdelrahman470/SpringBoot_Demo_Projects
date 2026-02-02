package com.cafeNcode.demo.rest;

import com.cafeNcode.demo.entity.Student;
import com.cafeNcode.demo.errorHandeler.StudentErrorResponse;
import com.cafeNcode.demo.errorHandeler.StudentNotFound;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> std;

    @PostConstruct
    public void settingData(){
        std = new ArrayList<>();

        std.add(new Student("abdo","mohamed"));
        std.add(new Student("ahmed","ali"));
        std.add(new Student("noha","ali"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return std;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){

        if((id >= std.size()) || (id) < 0){
            throw new StudentNotFound("student not found - " + id);
        }

        return std.get(id);
    }

}
