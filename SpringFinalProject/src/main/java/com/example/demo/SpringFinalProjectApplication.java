package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repo.StudentRepo;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackageClasses = StudentRepo.class)
public class SpringFinalProjectApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringFinalProjectApplication.class, args);
	}

}
