package com.TestProject.demo.Inheritances.JoinedTable;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Employeename;
    private Double Employeesalary;

}
