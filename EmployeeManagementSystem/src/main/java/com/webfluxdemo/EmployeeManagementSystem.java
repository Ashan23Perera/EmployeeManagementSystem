package com.webfluxdemo;

import com.webfluxdemo.entity.Employee;
import com.webfluxdemo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class EmployeeManagementSystem {

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementSystem.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystem.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {

		return (args) -> {
			// save a few employye details
			repository.saveAll(Arrays.asList(new Employee("Ashan", "Perera", "perea@gmail.com", 1000.00),
							new Employee("Umayanga", "Dasun", "dasun@gmail.com", 3000.00),
							new Employee("Diluka", "Witharana", "diluka@gmail.com", 5000.00),
							new Employee("Poorna", "Jayasena", "poorna@gmail.com", 7000.00),
							new Employee("Darren", "Ismail", "darren@gmail.com", 9000.00)))
					.blockLast(Duration.ofSeconds(10));
		};
	}

}
