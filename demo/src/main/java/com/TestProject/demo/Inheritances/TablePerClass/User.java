package com.TestProject.demo.Inheritances.TablePerClass;

import jakarta.persistence.*;

@Entity(name="user_tableperclass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//Table should not create so kept as abstract
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //uniquue ids for all sub classes so AUTO is used
    private long id;
}
