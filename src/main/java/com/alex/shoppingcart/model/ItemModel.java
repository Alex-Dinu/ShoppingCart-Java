package com.alex.shoppingcart.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class ItemModel {

    @Id
    private ObjectId id;
    private String description;
    private double price;
    private String imageFile;

    public ItemModel(String description, double price, String imageFile) {
        this.description = description;
        this.price = price;
        this.imageFile = imageFile;
    }

    public ItemModel() {
    }

    public String getId() {
        return id.toString();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

}
