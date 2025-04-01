package com.TestProject.demo.Dtos;

import lombok.Data;

@Data
public class ProductRequestDtos {
    private long id;
    private String title;
    private double price;
    private String description;
    private String  category;
    private String image;
    private Rating rating;

    // Getters
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public String getImage() {
        return image;
    }
    public Rating getRating() {
        return rating;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
