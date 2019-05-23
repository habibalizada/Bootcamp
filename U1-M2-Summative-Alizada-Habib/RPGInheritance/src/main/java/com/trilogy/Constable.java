package com.trilogy;

public class Constable extends Character {

    private String jurisdiction;

    public Constable(String name, String jurisdiction){
        super(60,100,60,20,5,name);
        this.jurisdiction = jurisdiction;

    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrest(){
        System.out.println("The Constable is arresting");

    }
}
