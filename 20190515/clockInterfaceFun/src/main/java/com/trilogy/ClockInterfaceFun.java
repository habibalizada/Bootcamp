package com.trilogy;

public class ClockInterfaceFun {
    public static void main(String[] args) {

        AnalogClock myAnalogClock = new AnalogClock();
        Buzzer myBuzzer = new Buzzer();
        DigitalClock myDigitalClock = new DigitalClock();

        System.out.println("");
        myAnalogClock.displayTime();
        myAnalogClock.timer();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Calling Buzzer.");
        myBuzzer.sound();

        System.out.println("----------------------------------------------------------------");
        System.out.print("Time is:");
        myDigitalClock.displayTime();
        System.out.println("Calling timer on Digital Clock");
        myDigitalClock.timer();
        System.out.println("Calling sound on Digital Clock");
        myDigitalClock.sound();
    }
}
