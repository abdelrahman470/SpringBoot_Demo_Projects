package com.cafe4code.cruddemo.dao;
import com.cafe4code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManagerInj){
        this.entityManager = entityManagerInj;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }
}
