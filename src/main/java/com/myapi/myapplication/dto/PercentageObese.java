package com.myapi.myapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PercentageObese implements Serializable {

    @JsonProperty("sexo")
    private String sex;
    @JsonProperty("percentual")
    private Float percentage;

    public PercentageObese() {
    }

    public PercentageObese(String sex, Float percentage) {
        this.sex = sex;
        this.percentage = percentage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float quantity) {
        this.percentage = quantity;
    }
}
