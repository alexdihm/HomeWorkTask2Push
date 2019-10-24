package com.example.junkfoodsrus.Model;

public class Food {

    private int id;
    private int imageID;
    private String name;
    private double price;
    private String description;

    public Food(int id, int imageID, String name, double price, String description) {
        this.id = id;
        this.imageID = imageID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
