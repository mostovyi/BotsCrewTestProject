package com.example.TestProject.model;

import com.example.TestProject.dao.Position;

import javax.persistence.*;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double salary;

    @OneToOne
    @JoinColumn(name = "department_id")
    Department department;

    @OneToOne
    @JoinColumn(name = "lector_id")
    Lector lector;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    @Enumerated(EnumType.STRING)
    private Position position;

    public Work() {}

    public Work(Department department, Lector lector, double salary, Position position) {
        this.department = department;
        this.lector = lector;
        this.salary = salary;
        this.position = position;
    }

    public Lector getLector() {
        return lector;
    }

    public Department getDepartment() {
        return department;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.lector.getFirstName() + " " + this.lector.getLastName() + " works in " +
                this.department.getName() + " department with salary " + this.salary + " on a "
                + this.position.toString() + " position.";
    }
}
