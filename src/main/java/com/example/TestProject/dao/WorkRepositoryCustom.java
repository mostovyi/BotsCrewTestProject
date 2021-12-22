package com.example.TestProject.dao;

import com.example.TestProject.model.Work;

import java.util.Map;

public interface WorkRepositoryCustom {

    Work findHeadOfDepartment(String department);

    Map<Degree, Integer> showDepartmentStatistics(String department);

    double averageDepartmentSalary(String department);

    int countDepartmentEmployers(String department);
}
