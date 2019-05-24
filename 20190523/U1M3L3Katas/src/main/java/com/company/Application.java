package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        int petIndex = -1;

        try {
             petIndex = Pets.choosePet();

        } catch (NumberFormatException ex){
            System.out.println("Please enter a valid number." + ex.getMessage());
       }


        String chosenPet = "";
        try {

             chosenPet = Pets.retrievePet(petIndex);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Please choose an available pet.");

        }


        try {

            Pets.readPetsFromFile();
        } catch (FileNotFoundException ex){
            System.out.println("The file does not exist" + ex.getMessage());
        }


        try{

            Pets.writePetToFile(chosenPet);
        } catch (IOException ex){
            System.out.println("File can not be opened" + ex.getMessage());
        }
        finally {
            System.out.println("Have a nice day!");
        }

    }
}
