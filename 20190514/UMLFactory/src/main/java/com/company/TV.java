package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean power;

    public TV(String manufacturer, String model, int screenSize) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.channel = "3";
        this.power = false;
    }

    public void togglePower() {
        this.power = !power;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        if (power) {
            this.channel = channel;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (power) {
            this.volume = volume;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public boolean isPower() {
        return power;
    }


}
