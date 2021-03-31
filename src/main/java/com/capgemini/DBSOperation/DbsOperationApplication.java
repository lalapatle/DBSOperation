package com.capgemini.DBSOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.capgemini")
@EntityScan( basePackages = "com.capgemini.entity")
@EnableJpaRepositories( basePackages = "com.capgemini.repository")
public class DbsOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsOperationApplication.class, args);
	}

}
