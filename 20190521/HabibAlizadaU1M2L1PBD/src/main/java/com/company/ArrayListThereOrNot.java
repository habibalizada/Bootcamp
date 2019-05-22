package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        Random randomGen = new Random();
        Scanner myScanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            myList.add(randomGen.nextInt(50) + 1);
        }
        System.out.println("ArrayList : " + myList);

        System.out.println("Value to find: ");
        int userInput = Integer.parseInt(myScanner.nextLine());

        boolean found = false;
        for (int anInt : myList){
            if (anInt == userInput){
                System.out.println(userInput + " is in the ArrayList.");
                found = true;
            }
        }
        if (!found){
            System.out.println(userInput + " is not in the ArrayList.");
        }
    }
}
