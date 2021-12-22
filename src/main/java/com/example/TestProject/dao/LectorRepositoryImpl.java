package com.example.TestProject.dao;

import com.example.TestProject.model.Lector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LectorRepositoryImpl implements LectorRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(WorkRepositoryImpl.class);

    @Override
    public List<Lector> searchBy(String line) {
        logger.info("Searching by {} keyword", line);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lector> query = cb.createQuery(Lector.class);
        Root<Lector> lector = query.from(Lector.class);
        query.select(lector);
        List<Lector> lectorList = entityManager.createQuery(query).getResultList();
        List<Lector> output = new ArrayList<>();
        for (Lector l : lectorList) {
            if(l.getLastName().contains(line) || l.getFirstName().contains(line))
                output.add(l);
        }

        logger.info("Search completed");

        return output;
    }
}
