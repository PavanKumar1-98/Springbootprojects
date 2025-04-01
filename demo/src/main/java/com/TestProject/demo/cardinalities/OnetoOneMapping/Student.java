package com.TestProject.demo.cardinalities.OnetoOneMapping;

import jakarta.persistence.*;

@Entity(name="student_onetoone")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne(mappedBy="student")
    Laptop laptop;

    //in the place of mappedBy we are keeping what we kept in Laptop class Student student (so we kept small student)


}
