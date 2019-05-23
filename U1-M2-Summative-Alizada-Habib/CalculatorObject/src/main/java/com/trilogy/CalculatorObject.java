package com.trilogy;

public class CalculatorObject {
    public static void main(String[] args) {

        Calculator myCalculator = new Calculator();

        System.out.println("\nOperations on different numbers: ");
        System.out.println("1  + 1  = " + myCalculator.add(1, 1));
        System.out.println("23 - 52 = " + myCalculator.subtract(23, 52));
        System.out.println("34  * 2 = " + myCalculator.multiply(34, 2));
        System.out.println("12 / 3 = " + myCalculator.divide(12, 3f));
        System.out.println("12 / 7 = " + myCalculator.divide(12f, 7f));
        System.out.println("3.4  + 2.3  = " + myCalculator.add(3.4f, 2.3f));
        System.out.println("6.7  * 4.4 = " + myCalculator.multiply(6.7f, 4.4f));
        System.out.println("5.5 - 0.5 = " + myCalculator.subtract(5.5f, 0.5f));
        System.out.println("10.8 / 2.2 = " + myCalculator.divide(10.8f, 2.2f));

    }
}
