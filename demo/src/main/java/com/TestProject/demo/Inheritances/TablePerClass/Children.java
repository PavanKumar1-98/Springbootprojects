package com.TestProject.demo.Inheritances.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="children_tableperclass")
public class Children extends User{

    private String username;
}
