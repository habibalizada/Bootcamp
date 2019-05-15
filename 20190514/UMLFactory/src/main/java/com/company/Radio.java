package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer, String model, int numSpeakers) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeakers = numSpeakers;
        this.station = "87.7";
        this.powered = false;
    }

    public void togglePower() {
        this.powered = !powered;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        if (powered) {
            this.station = station;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (powered) {
            this.volume = volume;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public boolean isPowered() {
        return powered;
    }
}
