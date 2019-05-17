package com.trilogy;

public class Sedan extends Car {

    int numDoors;
    boolean poweredWindows;

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isPoweredWindows() {
        return poweredWindows;
    }

    public void setPoweredWindows(boolean poweredWindows) {
        this.poweredWindows = poweredWindows;
    }

    public Sedan(int numDoors, boolean poweredWindows) {
        this.numDoors = numDoors;
        this.poweredWindows = poweredWindows;
    }
}
