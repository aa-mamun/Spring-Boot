package com.mamun.springrest.rest;

import com.mamun.springrest.domain.request.EmpRequest;
import com.mamun.springrest.domain.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {


    /**
     * Bellow method returns employee in JSON format
     * */
   @GetMapping(value = "/get-employee")
   public Employee  getEmployee(){
       return  new Employee(100,"Jon","Chicago");
   }

   /**
    * Get employee by id using @RequestParam
    * */
    @GetMapping(value = "/get-employee-by-id")
    public Employee  getEmployeeById(@RequestParam("id") int id){
       if(id == 100)
        return  new Employee(100,"Jon","Chicago");
       else if(id == 200)
           return  new Employee(200,"Cristina","New York");
       else
           return new Employee(0,"","");
    }


    /**
     * Get employee by id using @RequestBody
     * */
    @PostMapping(value = "/get-employee-by-id")
    public Employee  getEmployeeByIdRequestBody(@RequestBody EmpRequest request){
        int id = request.getId();
        if(id == 100)
            return  new Employee(100,"Jon","Chicago");
        else if(id == 200)
            return  new Employee(200,"Cristina","New York");
        else
            return new Employee(0,"","");
    }


}
