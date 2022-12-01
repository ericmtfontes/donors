package com.myapi.myapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AverageAgeByBloodType implements Serializable {

    @JsonProperty("tipo_sanguineo")
    private String bloodType;

    @JsonProperty("media")
    private Float average;

    public AverageAgeByBloodType() {
    }

    public AverageAgeByBloodType(String bloodType, Float average) {
        this.bloodType = bloodType;
        this.average = average;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }
}
