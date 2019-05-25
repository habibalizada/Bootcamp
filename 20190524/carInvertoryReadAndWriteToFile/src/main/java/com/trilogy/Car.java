package com.trilogy;

public class Car {

    private String make;
    private String model;
    private int year;
    private String color;
    private int odometer;

    public Car(String make, String model, int year, String color, int odometer) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
    }

    public Car(){

    }



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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Make: " + make + " Model:" + model + " Year: " + year + " Color: '" + color +" Odometer: " + odometer;
    }
}
