package com.mamun.springrest.rest;

import com.mamun.springrest.domain.request.EmployeeSaveRequest;
import com.mamun.springrest.domain.response.EmployeeSaveResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestConsumeController {

    public static final String PATH_EMPLOYEE_SAVE = "http://localhost:8080/employee/save";

    @GetMapping("/consume-save-employee")
    public String consumeRest() {
        EmployeeSaveRequest request = new EmployeeSaveRequest("Jon", "Lake zinit");

        RestTemplate restTemplate = new RestTemplate();

        EmployeeSaveResponse response = restTemplate.postForObject(PATH_EMPLOYEE_SAVE, request, EmployeeSaveResponse.class);


        return "SUCCESS";
    }

}
