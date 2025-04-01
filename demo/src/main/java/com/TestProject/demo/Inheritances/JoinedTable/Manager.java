package com.TestProject.demo.Inheritances.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="Employee_id") //optional as it is already extending it
//he @PrimaryKeyJoinColumn annotation specifies the name of the column (Employee_id) in the Developer table that acts as both:
//otherwise it will be id in the db table
public class Manager extends Employee{
    private String Managername;
    private Double Managersalary;
}
