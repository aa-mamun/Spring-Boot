package com.mamun.springdataaudit.repository;

import com.mamun.springdataaudit.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
