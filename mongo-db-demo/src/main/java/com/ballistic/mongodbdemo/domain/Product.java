package com.ballistic.mongodbdemo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Document
public class Product {

    @Id
    private ObjectId id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product() { }

    public Product(String description, BigDecimal price, String imageUrl) {

        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
