package com.mamun.springrest.rest;

import com.mamun.springrest.common.Response;
import com.mamun.springrest.common.Status;
import com.mamun.springrest.domain.entity.Employee;
import com.mamun.springrest.domain.request.EmployeeSaveRequest;
import com.mamun.springrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * As it is a demo I ignored the service layer
     **/

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping(value = "/save")
    public Response saveEmployee(@RequestBody EmployeeSaveRequest request){
        Response response = new Response();

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAddress(request.getAddress());

        Employee result = employeeRepository.save(employee);
        if (result.getId() != 0){
            response.setStatus(Status.SUCCCESS);
            response.setResponseCode("2000");
            response.setResponseMessage("Saved successfully");

        }else {
            response.setStatus(Status.FAIL);
            response.setResponseCode("2010");
            response.setResponseMessage("Failed to save");
        }

        return response;
    }
}
