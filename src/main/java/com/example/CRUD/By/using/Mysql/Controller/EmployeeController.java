package com.example.CRUD.By.using.Mysql.Controller;

import com.example.CRUD.By.using.Mysql.Entity.Employee;
import com.example.CRUD.By.using.Mysql.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/api/employee")
    public Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepo.save(newEmployee);
    }

    @GetMapping("/api/allEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("api/EmployeeId/{id}")
    public Optional<Employee> getEmployeeId(@PathVariable long id){
        return employeeRepo.findById(id);
    }

    @PutMapping("api/Employee/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable long id){
        Employee employee = employeeRepo.findById(id).get();
        employee.setName(newEmployee.getName());
        employee.setUsername(newEmployee.getUsername());
        employee.setAddress(newEmployee.getAddress());
        return employeeRepo.save(employee);
    }

    @DeleteMapping("api/Employee/{id}")
    public String deleteEmployee(@PathVariable long id){
        employeeRepo.deleteById(id);
        return "User Deleted Successfully";
    }
}
