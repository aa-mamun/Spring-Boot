package com.mamun.springdataaudit.controller;

import com.mamun.springdataaudit.domain.Employee;
import com.mamun.springdataaudit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RootController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/save")
    public String test(){
        Employee employee = new Employee("Jon", "New York");
        employeeRepository.save(employee);

        employeeRepository.saveAndFlush(employee);
        return "SAVED";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") int id){
        Optional<Employee> creator = employeeRepository.findById(id);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Jon Doe");
        employee.setAddress("California");
        employee.setCreatedBy(creator.get().getCreatedBy());
        employee.setCreationDate(creator.get().getCreationDate());

        employeeRepository.save(employee);

        return "UPDATED";
    }

 
}
