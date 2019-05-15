package com.trilogy;

public class ComputerMouse {
    private System manufacturer;
    private System model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public void move(int deltaX, int deltaY){
        System.out.println("The corsur is moved to the position x = " + deltaX + "and y = " + deltaY );
    }

    public void click(){
        System.out.println("The mouse button is clicked ");
    }
}
