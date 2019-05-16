package com.company;

import com.company.interfaces.Shape;

public class ShapeInterface {
    public static void main(String[] args) {

        Square mySquare = new Square(5);
        Circle myCircle = new Circle(3);
        Triangle myTriangle = new Triangle(3,4,5);

        System.out.println("The perimeter of square with side size of " + mySquare.getSideSize()+ " is: " + mySquare.perimeter());
        System.out.println("The perimeter of circle with radius size of " + myCircle.getRadius()+ " is: " + myCircle.perimeter());
        System.out.println("The perimeter of triangle with side size of " + myTriangle.getA()+ " and "
                +myTriangle.getB() + " and " + myTriangle.getC() +" is: " + myTriangle.perimeter());
    }
}
