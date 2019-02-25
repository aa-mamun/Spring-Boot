package com.mamun.inmemorydb.repository;

import com.mamun.inmemorydb.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
