package com.example.CRUD.By.using.Mysql.Repo;

import com.example.CRUD.By.using.Mysql.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
