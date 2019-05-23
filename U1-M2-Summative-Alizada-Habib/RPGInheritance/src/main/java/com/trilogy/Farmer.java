package com.trilogy;

public class Farmer extends Character {

    public Farmer(String name) {
        super(75, 100, 75, 10, 1,name);
    }

    public void plow(){
        System.out.println("The farmer is plowing.");

    }

    public void harvest(){
        System.out.println("The Farmer is harvesting.");

    }
}

