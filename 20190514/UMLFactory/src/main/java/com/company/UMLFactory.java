package com.company;

public class UMLFactory {
    public static void main(String[] args) {

        Car myCar1 = new Car("BMW" , "2020", "Sedan", "Black", "4.4 L", "Standard", 4, 22);
        Car myCar2 = new Car("Ford" , "2019", "Mustang", "Red", "5.0 L", "Automatic", 2, 15);

        System.out.println("My first car is " + myCar1.getModel()+ " "+ myCar1.getColor()+ " " + myCar1.getMake()+" "+myCar1.getType()+" "+myCar1.getEngine()+" "+ myCar1.getTransmission()+ " "+myCar1.getNumDoors()+" doors");
        System.out.println("My Second car is " + myCar2.getModel()+ " "+ myCar2.getColor()+ " " + myCar2.getMake()+" "+myCar2.getType()+" "+myCar2.getEngine()+" "+ myCar2.getTransmission()+ " "+myCar2.getNumDoors()+ " doors");

        myCar1.setColor("Yellow");
        myCar1.setMake("Toyota");
        myCar2.setMake("WV");
        myCar2.setColor("white");

        System.out.println("After modification my first car is " + myCar1.getModel()+ " "+ myCar1.getColor()+ " " + myCar1.getMake()+" "+myCar1.getType()+" "+myCar1.getEngine()+" "+ myCar1.getTransmission()+ " "+myCar1.getNumDoors()+" doors");
        System.out.println("After modification my Second car is " + myCar2.getModel()+ " "+ myCar2.getColor()+ " " + myCar2.getMake()+" "+myCar2.getType()+" "+myCar2.getEngine()+" "+ myCar2.getTransmission()+ " "+myCar2.getNumDoors()+ " doors");

        CoffeeMaker myCoffeeMaker1 = new CoffeeMaker(24, "Mr. Coffee", "JWXT");
        CoffeeMaker myCoffeeMaker2 = new CoffeeMaker(40, "Hamilton", "49980A");

        System.out.println("My first coffee maker is: " + myCoffeeMaker1.getManufacturer()+ " " + myCoffeeMaker1.getModel());
        System.out.println("My secon coffee maker is: " + myCoffeeMaker2.getManufacturer()+ " " + myCoffeeMaker2.getModel());

        ComputerMouse myComputerMouse1 = new ComputerMouse("Logitech", "M510");
        ComputerMouse myComputerMouse2 = new ComputerMouse("Microsoft Arch", "ELG-00001");

        System.out.println("My first computer mouse is " + myComputerMouse1.getManufacturer() + " " + myComputerMouse1.getModel());
        System.out.println("My second computer mouse is " + myComputerMouse2.getManufacturer() + " " + myComputerMouse2.getModel());

        Microwave myMicrowave1 = new Microwave("General Electric", "1.1 Cu");
        Microwave myMicrowave2 = new Microwave("Panasonic", "2.2 Cu");

        System.out.println("My first microwave is: " + myMicrowave1.getManufacturer() + " " + myMicrowave1.getModel());
        System.out.println("My second microwave is: " + myMicrowave2.getManufacturer() + " " + myMicrowave2.getModel());

        Radio myRadio1 = new Radio("Sony", "P26", 1);
        Radio myRadio2 = new Radio("Milwaukee", "M18", 2);

        System.out.println("My first radio is: " + myRadio1.getManufacturer() + " " + myRadio1.getModel());
        System.out.println("My second radio is: " + myRadio2.getManufacturer() + " " + myRadio2.getModel());

        TV myTv1 = new TV("Samsung", "UN55", 55);
        TV myTv2 = new TV("VISIO", "D50", 50);

        System.out.println("My first TV is: " + myTv1.getScreenSize()+ " inche " + myTv1.getManufacturer());
        System.out.println("My second TV is: " + myTv2.getScreenSize()+ " inche " + myTv2.getManufacturer());

    }
}
