package com.J3M.nwHacks2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NwHacks2023Application {

	public static void main(String[] args) {
		SpringApplication.run(NwHacks2023Application.class, args);
	}

}
