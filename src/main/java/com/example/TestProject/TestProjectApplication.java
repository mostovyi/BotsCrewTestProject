package com.example.TestProject;

import controller.Controller;
import dao.DepartmentRepository;
import dao.LectorRepository;
import dao.WorkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class TestProjectApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(TestProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("Starting request processing!");
		/*
		* Uncomment if you want to fill out your database again
		* */
		//DatabaseFiller.addData(lectorRepository, departmentRepository, workRepository);
		logger.info("Program was finished successfully");

	}
}
