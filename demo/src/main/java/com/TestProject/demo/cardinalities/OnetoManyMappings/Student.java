package com.TestProject.demo.cardinalities.OnetoManyMappings;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="student_OnetoMany")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy="student")
    private List<Laptop> laptop;
    //If we didnot keep mappedBy normal student_OnetoMany and another mappingtable will be created
}
