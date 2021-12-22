package com.example.TestProject;

import com.example.TestProject.controller.Controller;
import com.example.TestProject.dao.DepartmentRepository;
import com.example.TestProject.dao.LectorRepository;
import com.example.TestProject.dao.WorkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.TestProject.dao")

public class TestProjectApplication implements CommandLineRunner {

	@Autowired
	private LectorRepository lectorRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private WorkRepository workRepository;

	private final Logger logger = LoggerFactory.getLogger(TestProjectApplication.class);
	private final Controller controller = Controller.getInstance();
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

		controller.initialize(workRepository, lectorRepository);
		controller.processData(args);

		logger.info("Program was finished successfully");

	}
}
