package com.mamun.springdataaudit;

import com.mamun.springdataaudit.service.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories
@SpringBootApplication
public class SpringDataAuditApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringDataAuditApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}

