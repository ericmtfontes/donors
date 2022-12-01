package com.myapi.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class AverageImcByAge implements Serializable {

    @Id
    private Long id;
    @Column
    @JsonProperty("faixa_idade")
    private String age;
    @Column
    @JsonProperty("media")
    private Float average;

    public AverageImcByAge() {
    }

    public AverageImcByAge(Long id, String age, Float average) {
        this.id = id;
        this.age = age;
        this.average = average;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }
}
