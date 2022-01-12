package model;

import dao.Degree;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany
    @JoinTable( name = "employer_department",
                joinColumns = @JoinColumn(name = "lector_id"),
                inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departments;

    public Lector(String firstName, String lastName, Degree degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    public Lector() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return this.firstName + " | " + this.lastName + " | " + this.degree;
    }
}
