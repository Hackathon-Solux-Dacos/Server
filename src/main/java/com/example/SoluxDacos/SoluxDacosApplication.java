package com.example.SoluxDacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoluxDacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoluxDacosApplication.class, args);
	}

}
