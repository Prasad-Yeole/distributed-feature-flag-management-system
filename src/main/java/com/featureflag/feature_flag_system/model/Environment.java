package com.featureflag.feature_flag_system.model;

import jakarta.persistence.*;


@Entity
@Table(name = "environments")
public class Environment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    // getters & setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}