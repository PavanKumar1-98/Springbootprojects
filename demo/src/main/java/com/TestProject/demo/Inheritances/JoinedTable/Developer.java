package com.TestProject.demo.Inheritances.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="Employee_id")
public class Developer extends Employee{
    private String Developername;
    private Double Developersalary;
}
