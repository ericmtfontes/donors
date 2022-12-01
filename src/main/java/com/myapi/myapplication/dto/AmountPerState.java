package com.myapi.myapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AmountPerState implements Serializable {

    @JsonProperty("estado")
    private String state;
    @JsonProperty("quantidade")
    private Integer quantity;

    public AmountPerState() {
    }

    public AmountPerState(String state, Integer quantity) {
        this.state = state;
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
