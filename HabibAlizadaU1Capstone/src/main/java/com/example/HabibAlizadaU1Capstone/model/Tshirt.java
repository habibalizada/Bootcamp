package com.example.HabibAlizadaU1Capstone.model;

import javax.validation.constraints.*;
import java.util.Objects;

public class Tshirt {
    @NotNull
    private int tShirtId;
    @NotNull
    private String size;
    @NotNull
    private String color;
    @NotNull
    private String description;
    @NotNull
    @Min(0)
    @Digits(integer = 3, fraction = 2)
    private Double price;
    @PositiveOrZero
    @NotNull
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
                quantity == tshirt.quantity &&
                size.equals(tshirt.size) &&
                color.equals(tshirt.color) &&
                description.equals(tshirt.description) &&
                price.equals(tshirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
