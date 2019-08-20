package com.me.springrestservicedemo.config;

import com.me.springrestservicedemo.domain.entity.Employee;
import com.me.springrestservicedemo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Jon Doe", "admin")));
            log.info("Preloading " + repository.save(new Employee("Shophie Turner", "doctor")));
        };
    }
}

