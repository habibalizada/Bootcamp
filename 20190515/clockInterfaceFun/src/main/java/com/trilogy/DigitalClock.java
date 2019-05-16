package com.trilogy;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock implements Clock, Alarm {



    @Override
    public void displayTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm");
        Date myDate = new Date();
        System.out.println(myFormat.format(myDate));
    }

    @Override
    public void timer() {
        System.out.println("Timer has been set for Digital Clock");

    }

    @Override
    public void sound() {
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Beep sound played.");

    }
}
