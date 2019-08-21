package com.me.springrestservicedemo.config;

import com.me.springrestservicedemo.common.Status;
import com.me.springrestservicedemo.domain.entity.Employee;
import com.me.springrestservicedemo.domain.entity.Order;
import com.me.springrestservicedemo.repository.EmployeeRepository;
import com.me.springrestservicedemo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Jon Doe", "admin")));
            log.info("Preloading " + repository.save(new Employee("Shophie Turner", "doctor")));
            log.info("Preloading Order" + orderRepository.save(new Order("MacBook Pro", Status.COMPLETED)));
            log.info("Preloading Order" + orderRepository.save(new Order("iPhone", Status.IN_PROGRESS)));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}

