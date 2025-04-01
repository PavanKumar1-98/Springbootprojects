package com.TestProject.demo.Inheritances.Mappedsuperclass;


import jakarta.persistence.Entity;

@Entity
public class Mentor extends User {
    private String Mentorname;
    private String Mentorsubject;
}
