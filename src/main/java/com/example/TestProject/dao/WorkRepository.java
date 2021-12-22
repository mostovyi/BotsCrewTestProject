package com.example.TestProject.dao;


import com.example.TestProject.model.Lector;
import com.example.TestProject.model.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Long>, WorkRepositoryCustom {

}
