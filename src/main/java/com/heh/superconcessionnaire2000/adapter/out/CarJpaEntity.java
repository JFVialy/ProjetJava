package com.heh.superconcessionnaire2000.adapter.out;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid", nullable = false)
    private Integer id;

    @Column(name = "brand", nullable = false, length = 15)
    private String brand;

    @Column(name = "model", nullable = false, length = 15)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "\"trim\"", length = 30)
    private String trim;

    @Column(name = "kms", nullable = false)
    private Integer kms;

    @Column(name = "price", nullable = false)
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public Integer getKms() {
        return kms;
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}