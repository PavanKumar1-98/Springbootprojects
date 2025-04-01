package com.TestProject.demo.cardinalities.OnetoManyMappings;

import jakarta.persistence.*;

@Entity(name="laptop_onetomany")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String laptopcompany;
    @ManyToOne
    private Student student;
}
