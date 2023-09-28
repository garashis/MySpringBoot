package com.example.demo;

import jakarta.persistence.*;
import org.springframework.data.annotation.AccessType;

import java.io.Serializable;

@Entity
@Table(name = "mytesttable")
public class MyTestTable implements Serializable {

    @Id
    @Column(name="ctid")
    private String ctid;

    @Column(name="description")
    private String description;
    @Column(name="version")
    private int version;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
