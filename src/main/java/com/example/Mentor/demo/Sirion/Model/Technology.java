package com.example.Mentor.demo.Sirion.Model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Table(name = "TechnologiesTable")
public class Technology {

    @Id
    @GeneratedValue
    private long id;

    @Column
    String tech_name;

    @Column
    long duration;

    @Column
    String[] pre_req;

    @ColumnDefault("false")
    boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTech_name() {
        return tech_name;
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
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
