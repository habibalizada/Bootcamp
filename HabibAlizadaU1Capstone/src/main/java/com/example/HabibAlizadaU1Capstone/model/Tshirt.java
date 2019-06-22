package com.example.HabibAlizadaU1Capstone.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

public class Tshirt {
    private int tShirtId;
    private String size;
    private String color;
    private String description;
    @PositiveOrZero
    private double price;
    @PositiveOrZero
    private int quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirt tshirt = (Tshirt) o;
        return tShirtId == tshirt.tShirtId &&
                Double.compare(tshirt.price, price) == 0 &&
                quantity == tshirt.quantity &&
                size.equals(tshirt.size) &&
                color.equals(tshirt.color) &&
                description.equals(tshirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
