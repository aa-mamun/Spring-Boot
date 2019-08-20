package com.me.springrestservicedemo.repository;


import com.me.springrestservicedemo.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}