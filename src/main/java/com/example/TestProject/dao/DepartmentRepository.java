package com.example.TestProject.dao;

import com.example.TestProject.model.Department;
import com.example.TestProject.model.Lector;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
