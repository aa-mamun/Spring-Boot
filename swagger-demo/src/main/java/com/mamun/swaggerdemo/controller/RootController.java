package com.mamun.swaggerdemo.controller;

import com.mamun.swaggerdemo.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    /**
     * Bellow method returns employee in JSON format
     * */
    @GetMapping(value = "/get-employee")
    public Employee getEmployee(){

        return  new Employee(100,"Jon","Chicago");
    }




}
