package com.trilogy;

public class Warrior extends Character {

    private int shieldStrength;

    public Warrior(String name) {
        super(75, 100, 100, 50, 10, name);
        shieldStrength = 100;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public void decreaseShieldStrength(){
        System.out.println("The warrior's shield strength has decreased");

    }
}
