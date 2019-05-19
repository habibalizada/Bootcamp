package com.company.abstractapproach;

public class myMain {
    public static void main(String[] args) {

        Circle myCircle = new Circle("First circle", "Red", 100,200,10);
        Square mySquare = new Square("First square", "Yellow", 200, 300, 15);
        Triangle myTriangle = new Triangle("First Triangle", "Blue",300, 400, 30,40,50);

        System.out.println("--------------------The circle info--------------------");
        System.out.println("Name: " + myCircle.getName());
        System.out.println("Color: " + myCircle.getColor());
        System.out.println("Coordination: x = " + myCircle.getxCoord() + " y = " + myCircle.getyCoord());
        System.out.println("Radius: " + myCircle.getRadius());
        System.out.println("Area: " + myCircle.area());
        System.out.println("Perimeter: " + myCircle.perimeter());

        System.out.println("--------------------The square info--------------------");
        System.out.println("Name: " + mySquare.getName());
        System.out.println("Color: " + mySquare.getColor());
        System.out.println("Coordination: x = " + mySquare.getxCoord() + " y = " + mySquare.getyCoord());
        System.out.println("Side: " + mySquare.getSide());
        System.out.println("Area: " + mySquare.area());
        System.out.println("Perimeter: " + mySquare.perimeter());

        System.out.println("--------------------The triangle info--------------------");
        System.out.println("Name: " + myTriangle.getName());
        System.out.println("Color: " + myTriangle.getColor());
        System.out.println("Coordination: x = " + myTriangle.getxCoord() + " y = " + myTriangle.getyCoord());
        System.out.println("SideA: " + myTriangle.getSideA() + " SideB: " + myTriangle.getSideB() + " SideC: " + myTriangle.getSideC());
        System.out.println("Area: " + myTriangle.area());
        System.out.println("Perimeter: " + myTriangle.perimeter());
    }
}
