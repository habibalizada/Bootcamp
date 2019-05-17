package com.trilogy;

public class Accord extends Sedan {

    String year;
    Engine engine;
    Transmission transmission;

    public Accord(int numDoors, boolean poweredWindows, String year, Engine engine, Transmission transmission) {
        super(numDoors, poweredWindows);
        this.year = year;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
