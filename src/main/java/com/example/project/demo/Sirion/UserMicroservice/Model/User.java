package com.example.project.demo.Sirion.UserMicroservice.Model;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Table(name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @ColumnDefault("true")
    boolean active;

    @Column(nullable = false)
    String lORm;
}
