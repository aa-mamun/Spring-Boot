package com.mamun.lombokdemo.controller;

import com.mamun.lombokdemo.entity.EmployeeWithLombok;
import com.mamun.lombokdemo.entity.EmployeeWithLombokTwo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/one")
    public EmployeeWithLombok lombokDemo(){

        return new EmployeeWithLombok(100,"Sophie Turner","Actress");
    }

    @GetMapping("/two")
    public EmployeeWithLombokTwo lombokDemoTwo(){
        EmployeeWithLombokTwo employee = new EmployeeWithLombokTwo();
        employee.setId(200);
        employee.setName("Sansa");
        employee.setDesignation("Actress");

        return employee;
    }
}
