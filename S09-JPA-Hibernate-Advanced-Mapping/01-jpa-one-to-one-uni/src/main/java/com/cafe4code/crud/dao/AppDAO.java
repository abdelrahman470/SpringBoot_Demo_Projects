package com.cafe4code.crud.dao;

import com.cafe4code.crud.entity.Instructor;
import com.cafe4code.crud.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findById(int id);
    void delete(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteDetail(int id);
}
