package com.myapi.myapplication.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "donor")
public class Donor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonProperty("nome")
    private String name;
    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    @JsonProperty("data_nasc")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    @Column
    @JsonProperty("idade")
    private Integer age;
    @Column
    @JsonProperty("sexo")
    private String sex;
    @Column
    @JsonProperty("mae")
    private String mother;
    @Column
    @JsonProperty("pai")
    private String dad;
    @Column
    private String email;
    @Column
    @JsonProperty("cep")
    private String zipCode;
    @Column
    @JsonProperty("endereco")
    private String address;
    @Column
    @JsonProperty("numero")
    private Integer number;
    @Column
    @JsonProperty("bairro")
    private String district;
    @Column
    @JsonProperty("cidade")
    private String city;
    @Column
    @JsonProperty("estado")
    private String state;
    @Column
    @JsonProperty("telefone_fixo")
    private String landline;
    @Column
    @JsonProperty("celular")
    private String cell;
    @Column
    @JsonProperty("altura")
    private Float height;
    @Column
    @JsonProperty("peso")
    private Float weight;
    @Column
    private Float imc;
    @Column
    @JsonProperty("tipo_sanguineo")
    private String bloodType;
    @Column
    @JsonProperty("pode_doar")
    private Boolean canDonate;

    public Donor() {
    }

    public Donor(Long id, String name, String cpf, String rg, Date birthDate, Integer age, String sex, String mother, String dad, String email, String zipCode, String address, Integer number, String district, String city, String state, String landline, String cell, Float height, Float weight, Float imc, String bloodType, Boolean canDonate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.age = age;
        this.sex = sex;
        this.mother = mother;
        this.dad = dad;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.landline = landline;
        this.cell = cell;
        this.height = height;
        this.weight = weight;
        this.imc = imc;
        this.bloodType = bloodType;
        this.canDonate = canDonate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getDad() {
        return dad;
    }

    public void setDad(String dad) {
        this.dad = dad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Boolean getCanDonate() {
        return canDonate;
    }

    public void setCanDonate(Boolean canDonate) {
        this.canDonate = canDonate;
    }
}
