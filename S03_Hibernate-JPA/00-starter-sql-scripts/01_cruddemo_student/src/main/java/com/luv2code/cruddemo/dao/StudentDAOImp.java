package com.luv2code.cruddemo.dao;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager
    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // findById method
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findall() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                    "from Student where lastName =:data", Student.class);

        // set query parameter
        theQuery.setParameter("data", lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void removeById(int studentId) {
        Student theStudent = entityManager.find(Student.class, studentId);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery(
                            "delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
