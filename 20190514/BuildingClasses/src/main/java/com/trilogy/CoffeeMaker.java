package com.trilogy;

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public void brew(){
        System.out.println("Coffee is getting brewed.");
    }

    public void pourCoffee(int numCups){
        System.out.println(numCups + " cups of coffee are coming!");
    }
}
