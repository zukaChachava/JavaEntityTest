package com.example.companymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CompanyManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyManagementApplication.class, args);
    }

}