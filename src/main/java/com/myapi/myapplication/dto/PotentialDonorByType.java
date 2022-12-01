package com.myapi.myapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PotentialDonorByType implements Serializable {

    @JsonProperty("tipo_sanguineo")
    private String bloodType;

    @JsonProperty("quantidade")
    private Integer quantity;

    public PotentialDonorByType() {
    }

    public PotentialDonorByType(String bloodType, Integer quantity) {
        this.bloodType = bloodType;
        this.quantity = quantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
