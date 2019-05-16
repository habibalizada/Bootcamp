package com.trilogy;

public class AnalogClock implements Clock {

    @Override
    public void displayTime() {
        System.out.println("The hour handle shows hour and minute handle shows minute.");

    }

    @Override
    public void timer() {
        System.out.println("Timer has ben set for Analog Clock.");

    }
}
