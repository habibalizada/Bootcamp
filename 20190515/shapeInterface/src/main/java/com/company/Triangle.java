package com.company;

import com.company.interfaces.Shape;

public class Triangle implements Shape {

    private double a = 0;
    private double b = 0;
    private double c = 0;
    private double area = 0 ;
    private double perim = 0;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


    @Override
    public double perimeter() {

        if((a+b)>c && (a+c)>b && (b+c)>a)
        {
            perim = a + b + c;
        }
        else {
            perim = 0;
            System.out.println("This Triangle not exit");
        }

        return perim;
    }

    @Override
    public double area() {

        if((a+b)>c && (a+c)>b && (b+c)>a)
        {
            double s=(a+b+c)/2;
            area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        }
        else {
            area = 0;
            System.out.println("Area of Triangle not exit");
        }
        return 0;
    }
}
