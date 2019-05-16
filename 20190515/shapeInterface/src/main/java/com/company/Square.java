package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {

    private double sideSize = 0;

    public Square(double sideSize) {
        this.sideSize = sideSize;
    }

    public double getSideSize() {
        return sideSize;
    }

    public void setSideSize(double sideSize) {
        this.sideSize = sideSize;
    }

    @Override
    public double perimeter() {
        return sideSize * 4;
    }

    @Override
    public double area() {
        return sideSize * sideSize;
    }
}
