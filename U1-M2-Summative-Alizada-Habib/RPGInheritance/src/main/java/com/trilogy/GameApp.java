package com.trilogy;

public class GameApp {
    public static void main(String[] args) {

        Character farmer = new Farmer("Dave");
        Character constable = new Constable("Mark", "The city");
        Character warrior = new Warrior("James");

        System.out.println("The farmer's name is: " + farmer.getName());
        System.out.println("The farmer's attack power is " + farmer.getAttackPower());
        System.out.println("The farmer's health level is " + farmer.getHealth());
        System.out.println("The farmer's speed is " + farmer.getSpeed());
        System.out.println("The farmer's stamina level is " + farmer.getStamina());
        System.out.println("The farmer's strength is " + farmer.getStrength());
        System.out.print("The farmer's strength is " );
        farmer.attack();
        System.out.print("The farmer's health is " );
        farmer.decreaseHealth();
        System.out.print("The farmer's stamina is " );
        farmer.decreaseStamina();
        System.out.print("The farmer's is " );
        farmer.heal();
        System.out.print("The farmer's stamina is " );
        farmer.increaseStamina();


        System.out.println("The constable's name is: " + constable.getName());
        System.out.println("The constable's attack power is " + constable.getAttackPower());
        System.out.println("The constable's health level is " + constable.getHealth());
        System.out.println("The constable's speed is " + constable.getSpeed());
        System.out.println("The constable's stamina level is " + constable.getStamina());
        System.out.println("The constable's strength is " + constable.getStrength());
        System.out.print("The constable's strength is " );
        constable.attack();
        System.out.print("The constable's health is " );
        constable.decreaseHealth();
        System.out.print("The constable's stamina is " );
        constable.decreaseStamina();
        System.out.print("The constable's is " );
        constable.heal();
        System.out.print("The constable's stamina is " );
        constable.increaseStamina();


        System.out.println("The warrior's name is: " + warrior.getName());
        System.out.println("The warrior's attack power is " + warrior.getAttackPower());
        System.out.println("The warrior's health level is " + warrior.getHealth());
        System.out.println("The warrior's speed is " + warrior.getSpeed());
        System.out.println("The warrior's stamina level is " + warrior.getStamina());
        System.out.println("The warrior's strength is " + warrior.getStrength());
        System.out.print("The warrior's strength is " );
        warrior.attack();
        System.out.print("The warrior's health is " );
        warrior.decreaseHealth();
        System.out.print("The warrior's stamina is " );
        warrior.decreaseStamina();
        System.out.print("The warrior's is " );
        warrior.heal();
        System.out.print("The warrior's stamina is " );
        warrior.increaseStamina();

    }
}
