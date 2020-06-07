package com.example.tejas.SpringBootLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.example.tejas.SpringBootLearning"})
// @EnableJpaRepositories
@EnableJpaRepositories("com.example.tejas.SpringBootLearning.DAO")
// @EntityScan("com.example.tejas.SpringBootLearning.DAO")
public class SpringBootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}

}
