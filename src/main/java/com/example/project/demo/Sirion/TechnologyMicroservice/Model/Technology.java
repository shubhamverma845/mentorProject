package com.example.project.demo.Sirion.TechnologyMicroservice.Model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Table(name = "TechnologiesTable")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String techName;

    @Column
    long duration;

    @Column
    String[] pre_req;

    @ColumnDefault("false")
    boolean status;

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String[] getPre_req() {
        return pre_req;
    }

    public void setPre_req(String[] pre_req) {
        this.pre_req = pre_req;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
