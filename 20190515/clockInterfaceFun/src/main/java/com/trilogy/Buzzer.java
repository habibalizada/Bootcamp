package com.trilogy;

import java.awt.*;

public class Buzzer implements Alarm {

    @Override
    public void sound() {
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Beep sound played.");

    }
}
