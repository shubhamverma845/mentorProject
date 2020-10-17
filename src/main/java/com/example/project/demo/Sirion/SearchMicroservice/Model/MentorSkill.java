package com.example.project.demo.Sirion.SearchMicroservice.Model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Table(name = "MentorSkillTable")
public class MentorSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    long mentorId;

    @Column
    long[] techId;

    @ColumnDefault("2.5")
    float rating;

    @ColumnDefault("0")
    long trainingsDelivered;
}
