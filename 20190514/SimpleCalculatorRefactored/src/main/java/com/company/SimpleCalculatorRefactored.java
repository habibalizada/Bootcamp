package com.company;

public class SimpleCalculatorRefactored {
    public static void main(String[] args) {

        Calculator myCalculator = new Calculator();

        System.out.println("\nOperations on int numbers: ");
        System.out.println("4  + 9  = " + myCalculator.add(4, 9));
        System.out.println("22 - 14 = " + myCalculator.subtract(22, 14));
        System.out.println("6  * 11 = " + myCalculator.multiply(6, 1));
        System.out.println("88 / 22 = " + myCalculator.divide(88, 22));

        System.out.println("\nOperations on float numbers: ");
        System.out.println("3.2f + 7.9f  = " + myCalculator.add(3.2f, 7.9f));
        System.out.println("10.3f - 4.22f = " + myCalculator.subtract(10.3f, 4.22f));
        System.out.println("6.1f * 11.5f = " + myCalculator.multiply(6.1f, 11.5f));
        System.out.println("22.4f / 3.67f = " + myCalculator.divide(22.4f, 3.6f));

        System.out.println("\nOperations on double numbers: ");
        System.out.println("66.33 + 77.41  = " + myCalculator.add(66.33, 77.41));
        System.out.println("104.29 - 36.23 = " + myCalculator.subtract(104.29, 36.23));
        System.out.println("48.1 * 2.4 = " + myCalculator.multiply(48.1, 2.4));
        System.out.println("90.432 / 44.12 = " + myCalculator.divide(90.432, 44.12));

        System.out.println("\nOperations on long numbers: ");
        System.out.println("33L + 307L  = " + myCalculator.add(33L, 307L));
        System.out.println("840L - 501L = " + myCalculator.subtract(840L, 501L));
        System.out.println("26L * 13L = " + myCalculator.multiply(26L, 13L));
        System.out.println("7414L / 22L = " + myCalculator.divide(7114L, 22L));
/*
*
* 4 + 9
    22 - 14
    6 * 11
    88 / 22

    floats:
    3.2f + 7.9f
    10.3f - 4.22f
    6.1f * 11.5f
    22.4f / 3.67f

    doubles:
    66.33 + 77.41
    104.29 - 36.23
    48.1 * 2.4
    90.432 / 44.12

    long:
    33L + 307L
    840L - 501L
    26L * 13L
    7414L / 22L
*
*
* */
    }
}
