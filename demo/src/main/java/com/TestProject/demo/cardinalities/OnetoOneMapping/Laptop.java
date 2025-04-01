package com.TestProject.demo.cardinalities.OnetoOneMapping;

import jakarta.persistence.*;

@Entity(name="laptop_OnetoOne")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String LaptopCompany;

    @OneToOne
    Student student;

}
