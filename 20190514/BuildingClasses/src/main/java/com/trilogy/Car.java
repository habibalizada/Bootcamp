package com.trilogy;

public class Car {

    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmition;
    private int numDoors;
    private double mpg;
    private int mileDriven;

    public void drive(int miles){
        System.out.println("The car is driving with " + miles + " miles per hour.");
    }

    public void hunk(){
        System.out.println("BEEEEEEEEEEP");
    }
}
