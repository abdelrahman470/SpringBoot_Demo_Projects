package com.luv2code.cruddemo.dao;
import com.luv2code.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(int id);
    List<Student> findall();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void removeById(int studentId);
    int deleteAll();
}
