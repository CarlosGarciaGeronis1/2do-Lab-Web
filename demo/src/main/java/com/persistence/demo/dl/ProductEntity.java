package com.persistence.demo.dl;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

    public ProductEntity() {
    }
    // class name and field names are identical to column names of the table product

    @Id // indicating the member field below is the primary key of current entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use server side strategy (MySQL auto-increment)
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
