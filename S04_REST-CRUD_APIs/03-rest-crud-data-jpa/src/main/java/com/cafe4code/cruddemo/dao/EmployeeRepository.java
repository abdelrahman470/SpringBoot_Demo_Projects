package com.cafe4code.cruddemo.dao;
import com.cafe4code.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // By default, it adds 's' to the end of repository
    // that's it !.....wooooow
}
