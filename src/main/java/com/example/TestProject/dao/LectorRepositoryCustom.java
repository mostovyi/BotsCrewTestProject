package com.example.TestProject.dao;

import com.example.TestProject.model.Lector;

import java.util.List;

public interface LectorRepositoryCustom {

    List<Lector> searchBy(String line);

}
