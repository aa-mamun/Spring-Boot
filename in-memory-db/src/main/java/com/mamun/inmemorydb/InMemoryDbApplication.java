package com.mamun.inmemorydb;

import com.mamun.inmemorydb.domain.Employee;
import com.mamun.inmemorydb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InMemoryDbApplication {


    public static void main(String[] args) {
        SpringApplication.run(InMemoryDbApplication.class, args);
    }

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Three rows will be inserted to "Employee" table of "testdb"
     * database at runtime
     * */
    @PostConstruct
    private void initDb() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jon","New York"));
        employees.add(new Employee("Ron","New York"));
        employees.add(new Employee("Sansa","North"));
        employeeRepository.saveAll(employees);

    }
}
