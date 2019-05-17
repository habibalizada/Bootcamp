package com.trilogy;

public class Car implements Vehicle {

    String make;
    String model;
    int milesTraveled;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    @Override
    public void drive() {
        System.out.println("Vehicle is going.");

    }

    @Override
    public void displayMilesTraveled() {
        System.out.println("Here is your the number of mile is traveled.");

    }
}
