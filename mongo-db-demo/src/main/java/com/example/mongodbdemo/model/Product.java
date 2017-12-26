package com.example.mongodbdemo.model;

/**
 * Created by Nabeel on 12/24/2017.
 */
public class Product {

    private String code;
    private String name;
    private String details;

    public Product() {
    }

    public Product(String code, String name, String details) {
        this.code = code;
        this.name = name;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
