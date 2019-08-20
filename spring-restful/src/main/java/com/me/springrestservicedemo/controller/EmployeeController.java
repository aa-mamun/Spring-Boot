package com.me.springrestservicedemo.controller;

import com.me.springrestservicedemo.domain.entity.Employee;
import com.me.springrestservicedemo.exception.EmployeeNotFoundException;
import com.me.springrestservicedemo.helper.EmployeeResourceAssembler;
import com.me.springrestservicedemo.repository.EmployeeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    private final EmployeeResourceAssembler assembler;

    EmployeeController(EmployeeRepository repository,
                       EmployeeResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }
    // Aggregate root

    /*@GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }*/

    /**
     *link added as a part of building Restful service
     * */
    /*@GetMapping("/employees")
    public Resources<Resource<Employee>> all() {

        List<Resource<Employee>> employees = repository.findAll().stream()
                .map(employee -> new Resource<>(employee,
                        linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
                .collect(Collectors.toList());

        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }*/

   /**
    * Simplifying Link Creation
    * */
   @GetMapping("/employees")
   public Resources<Resource<Employee>> all() {

       List<Resource<Employee>> employees = repository.findAll().stream()
               .map(assembler::toResource)
               .collect(Collectors.toList());

       return new Resources<>(employees,
               linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
   }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

   /* @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }*/

   /**
    * Link added
    * */
    /*@GetMapping("/employees/{id}")
    public Resource<Employee> one(@PathVariable Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return new Resource<>(employee,
                linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }*/

    /**
     * Simplifying Link Creation
     * */
   @GetMapping("/employees/{id}")
   public Resource<Employee> one(@PathVariable Long id) {

       Employee employee = repository.findById(id)
               .orElseThrow(() -> new EmployeeNotFoundException(id));

       return assembler.toResource(employee);
   }
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
