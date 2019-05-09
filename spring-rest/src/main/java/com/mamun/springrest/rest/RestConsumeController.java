package com.mamun.springrest.rest;

import com.mamun.springrest.domain.request.EmployeeSaveRequest;
import com.mamun.springrest.domain.response.EmployeeSaveResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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


    @GetMapping("/consume-employee-details")
    public String getEmployeeDetails() {

        String uri="http://localhost:8080/employee/get-details?name=Jon&address=NY";

        RestTemplate restTemplate = new RestTemplate();
        String details=restTemplate.getForObject(uri,String.class);

        return details;
    }

    @GetMapping("/consume-employee-details-two")
    public String getEmployeeDetailsTwo() {
        String uri="http://localhost:8080/employee/get-details";

        RestTemplate  restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("name", "Jon")
                .queryParam("address", "NY");

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class
        );


        return responseEntity.getBody();
    }

}
