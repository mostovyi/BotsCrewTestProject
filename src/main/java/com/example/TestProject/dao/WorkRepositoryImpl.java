package com.example.TestProject.dao;

import com.example.TestProject.model.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkRepositoryImpl implements WorkRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(WorkRepositoryImpl.class);
    @Override
    public Work findHeadOfDepartment(String department) {

        logger.info("Searching head of {} department", department);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Work> query = cb.createQuery(Work.class);

        Root<Work> work = query.from(Work.class);
        query.select(work);

        logger.info("Search successfully completed");

        return entityManager.createQuery(query).getResultList().stream().filter(w -> w.getDepartment().getName().equals(department) && w.getPosition().toString().equals("Head")).findFirst().orElse(null);
    }

    @Override
    public Map<Degree, Integer> showDepartmentStatistics(String department) {

        logger.info("Collecting {} department statistics", department);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Work> query = cb.createQuery(Work.class);

        Map<Degree, Integer> resultMap = new HashMap<>();

        resultMap.put(Degree.assistant, 0);
        resultMap.put(Degree.associate_professor, 0);
        resultMap.put(Degree.professor, 0);

        Root<Work> work = query.from(Work.class);
        query.select(work);
        List<Work> workList = entityManager.createQuery(query).getResultList();



        for(Work w : workList) {
            final Degree d = w.getLector().getDegree();
            resultMap.forEach((degree, value) -> {if(degree.equals(d) && w.getDepartment().getName().equals(department))
            resultMap.put(d, ++value); });
        }

        logger.info("Search successfully completed");

        return resultMap;
    }

    @Override
    public double averageDepartmentSalary(String department) {
        double avarageSalary = 0;
        int workersAmount = 0;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Work> query = cb.createQuery(Work.class);
        Root<Work> work = query.from(Work.class);
        query.select(work);
        List<Work> workList = entityManager.createQuery(query).getResultList();

        logger.info("Counting avarage department {} salary", department);

        for(Work w : workList) {
            if(w.getDepartment().getName().equals(department)) {

                System.out.println(w);
                ++workersAmount;
                avarageSalary += w.getSalary();

            }
        }


        System.out.println("Total department salary is : " + avarageSalary);

        if(avarageSalary == 0 || workersAmount == 0) {
            logger.error("Empty Department, can not calculate average salary -> no employers");
            throw new ArithmeticException("Dividing by ZERO! ");
        }

        logger.info("Search successfully completed");

        return avarageSalary / workersAmount;
    }

    @Override
    public int countDepartmentEmployers(String department) {
        int workersAmount = 0;

        logger.info("Counting department {} employers", department);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Work> query = cb.createQuery(Work.class);
        Root<Work> work = query.from(Work.class);
        query.select(work);
        List<Work> workList = entityManager.createQuery(query).getResultList();

        for(Work w : workList) {
            if (w.getDepartment().getName().equals(department)) {
                ++workersAmount;
            }
        }

        logger.info("Search successfully completed");

        return workersAmount;
    }
}
