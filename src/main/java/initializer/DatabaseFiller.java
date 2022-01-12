package initializer;

import dao.*;
import model.Department;
import model.Lector;
import model.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DatabaseFiller {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseFiller.class);
    public static void addData(LectorRepository lectorRepository, DepartmentRepository departmentRepository, WorkRepository workRepository) {

        Lector lector1 = new Lector("Daniil", "Danilov", Degree.ASSISTANT);
        Lector lector2 = new Lector("Alex", "Alexandrov", Degree.ASSOCIATE_PROFESSOR);
        Lector lector3 = new Lector("Max", "Mustermann", Degree.ASSOCIATE_PROFESSOR);
        Lector lector4 = new Lector("Goga", "Gogovich", Degree.PROFESSOR);
        Lector lector5 = new Lector("Igor", "Igorov", Degree.ASSISTANT);
        Lector lector6 = new Lector("Example", "Beispiel", Degree.PROFESSOR);
        Lector lector7 = new Lector("Name", "Surname", Degree.ASSISTANT);
        Lector lector8 = new Lector("Johannes", "Beispiel", Degree.ASSISTANT);
        Lector lector9 = new Lector("Berthold", "Hochl", Degree.PROFESSOR);
        Lector lector10 = new Lector("Michail", "Mihailov", Degree.ASSISTANT);

        ArrayList<Lector> lectors = new ArrayList<>(Arrays.asList(lector1, lector2, lector3, lector4, lector5, lector6,
                lector7, lector8, lector9, lector10));

        Department department = new Department("Computer Science");
        Department department2 = new Department("Philosophy");
        Department department3 = new Department("Math");
        Department department4 = new Department("Unknown Science");

        ArrayList<Department> departments = new ArrayList<>(Arrays.asList(department, department2, department3, department4));

        departments.forEach(dep -> {departmentRepository.save(dep);
                                    logger.info("Department {} was added", dep);
        });
        // Setting lector1
        Set<Department> dep = new HashSet<>();
        dep.add(department);
        dep.add(department2);
        setDepartments(lector1, dep);
        // Setting lector2
        dep.clear();
        dep.add(department3);
        setDepartments(lector2, dep);
        // Setting lector3
        dep.add(department4);
        setDepartments(lector3, dep);
        // Setting lector4
        dep.clear();
        dep.add(department);
        dep.add(department4);
        setDepartments(lector4, dep);
        // Setting Lector5
        dep.clear();
        dep.add(department3);
        setDepartments(lector5, dep);
        // Setting Lector6
        dep.clear();
        dep.add(department4);
        setDepartments(lector6, dep);
        // Setting Lector7
        dep.add(department2);
        setDepartments(lector7, dep);
        // Setting Lector8
        dep.clear();
        dep.add(department3);
        setDepartments(lector8, dep);
        // Setting Lector9
        dep.add(department);
        setDepartments(lector9, dep);
        // Setting Lector10
        dep.add(department2);
        setDepartments(lector10, dep);

        // Saving Lectors in Database
        lectors.forEach(lec -> { lectorRepository.save(lec);
                                 logger.info("Lector {} was added", lec);
        });

        // Registering work
        ArrayList<Work> works = new ArrayList<>(Arrays.asList(
         new Work(department, lector1, 1000, Position.EMPLOYER),
        new Work(department2, lector1, 100, Position.EMPLOYER),
        new Work(department3, lector2, 2000, Position.HEAD),
        new Work(department3, lector3, 500, Position.EMPLOYER),
        new Work(department4, lector3, 500, Position.EMPLOYER),
        new Work(department, lector4, 3000, Position.HEAD),
        new Work(department4, lector4, 100, Position.EMPLOYER),
        new Work(department3, lector5, 400, Position.EMPLOYER),
        new Work(department4, lector6, 2000, Position.HEAD),
        new Work(department2, lector7, 1500, Position.HEAD),
        new Work(department4, lector7, 600, Position.EMPLOYER),
        new Work(department4, lector8, 500, Position.EMPLOYER),
        new Work(department3, lector9, 600, Position.EMPLOYER),
        new Work(department, lector9, 600, Position.EMPLOYER),
        new Work(department3, lector10, 600, Position.EMPLOYER),
        new Work(department, lector10, 700, Position.EMPLOYER),
        new Work(department, lector10, 800, Position.EMPLOYER)));

        works.forEach(w -> {workRepository.save(w);
                            logger.info("Lector {} was registered for a work in department of {}.", w.getLector(), w.getDepartment());});

    }

    private static void setDepartments(Lector lector, Set<Department> dep) {
        lector.setDepartments(dep);
        logger.info("Lector {} was assigned to department : {}.", lector, dep);
    }
}
