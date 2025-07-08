package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HelloWorldService {

    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getMethod() {
        return empRepo.findAll();
    }


    public Employee getEmployeeById(int empid) {
        return empRepo.findById(empid).orElse(new Employee());
    }

    public List<Employee> getEmployeeByJob(String job) {
        return empRepo.findByJob(job);
    }

    public String postmethodhws(Employee employee) {
        empRepo.save(employee);
        return "Employee Added Successfully";
    }

    public String putMethod(Employee employee) {
        if (empRepo.existsById(employee.getEmpid())) {
            empRepo.save(employee);
            return "Employee Updated Successfully";
        } else {
            return "Employee ID does not exist, cannot update";
        }
    }

    public String DeleteMethod() {
        empRepo.deleteAll();
        return  "All deleted successfully";
    }

    public void DeleteById(int empid) {
        empRepo.deleteById(empid);
    }

}
