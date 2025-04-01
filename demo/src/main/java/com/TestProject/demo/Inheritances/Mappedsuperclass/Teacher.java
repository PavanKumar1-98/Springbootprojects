package com.TestProject.demo.Inheritances.Mappedsuperclass;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends User{
    private String Teachername;
    private String Teachersalary;
}
