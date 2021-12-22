package com.example.TestProject.dao;

import com.example.TestProject.model.Lector;
import org.springframework.data.repository.CrudRepository;

public interface LectorRepository extends CrudRepository<Lector, Long>, LectorRepositoryCustom {
}
