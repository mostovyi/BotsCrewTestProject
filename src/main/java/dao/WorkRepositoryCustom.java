package dao;

import model.Work;

import java.util.Map;

public interface WorkRepositoryCustom {

    Work findHeadOfDepartment(String department);

    Map<Degree, Integer> showDepartmentStatistics(String department);

    double averageDepartmentSalary(String department);

    int countDepartmentEmployers(String department);
}
