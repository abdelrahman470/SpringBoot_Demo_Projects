package com.cafe4code.crud.dao;
import com.cafe4code.crud.entity.Instructor;
import com.cafe4code.crud.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImp implements AppDAO{

    private final EntityManager entityManager;
    @Autowired
    public AppDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = entityManager.find(Instructor.class ,id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteDetail(int id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class ,id);

        // break bi-directional link
        detail.getInstructor().setInstructorDetail(null);

        entityManager.remove(detail);
    }






}
