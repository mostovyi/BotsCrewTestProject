package controller;

import dao.Degree;
import dao.LectorRepository;
import dao.WorkRepository;
import exceptions.EmptyCommandLineException;
import model.Lector;
import parser.StringParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private final WorkRepository workRepository;
    private final LectorRepository lectorRepository;

    public Controller(WorkRepository workRepository, LectorRepository lectorRepository) {
        logger.info("Initializing...");
        this.workRepository = workRepository;
        this.lectorRepository = lectorRepository;
    }

    public void processData(String[] args) {

        if(args.length == 0) {
            logger.error("Empty argument line, please add arguments in the following format: mvn spring-boot:run -Dspring-boot.run.arguments=\" \"");
            throw new EmptyCommandLineException("No arguments found");
        }
        StringParser parser = new StringParser();

        final String[] function = parser.parseLine(args);

        switch (function[0]) {
            case "head" -> this.findHeadOfDepartment(function[1]);
            case "statistics" -> this.showDepartmentStatistics(function[1]);
            case "salary" -> this.showAverageDepartmentSalary(function[1]);
            case "count" -> this.countEmployers(function[1]);
            case "search" -> this.searchBy(function[1]);
        }
    }

    public void findHeadOfDepartment(String department) { this.printSingleMMessage(this.workRepository.findHeadOfDepartment(department).toString()); }

    public void showDepartmentStatistics(String department) {

        System.out.println();
        System.out.println("SEARCH RESULT : ");
        Map<Degree, Integer> output = this.workRepository.showDepartmentStatistics(department);
        output.forEach((key, value) -> System.out.println(department + " department has " + " " + value + " " + key.toString()));
        System.out.println();

    }

    public void showAverageDepartmentSalary(String department) {

        String message = "Average " + department + " department salary is : " + this.workRepository.averageDepartmentSalary(department);
        this.printSingleMMessage(message);

    }

    public void countEmployers(String department) {

        String message = department + " department has : " + this.workRepository.countDepartmentEmployers(department) + " Employers";
        this.printSingleMMessage(message);

    }

    public void searchBy(String line) {

        System.out.println();
        System.out.println("SEARCH RESULT : ");
        List<Lector> output = this.lectorRepository.searchBy(line);
        output.forEach(System.out::println);
        System.out.println();

    }

    private void printSingleMMessage(String message) {
        System.out.println();
        System.out.println("SEARCH RESULT : ");
        System.out.println(message);
        System.out.println();
    }

}
