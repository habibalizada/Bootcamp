package com.trilogy;

public class Microwave {

    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public void start(int secondsLeft){
        System.out.println("The microwave is set to run for " + secondsLeft + " seconds.");
    }

    public void stop(){
        System.out.println("The microwave is stopped.");
    }

    public void clear(){
        System.out.println("The microwave is cleaning.");
    }
}
