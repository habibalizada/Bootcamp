package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CopyingArrayLists {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        Random randomGen = new Random();

        for (int i = 0; i < 10; i++) {
            myList.add(randomGen.nextInt(100) + 1);
        }

        ArrayList<Integer> myList2 = (ArrayList<Integer>) myList.clone();

        myList.set(myList.size()-1, -7);

        System.out.println("ArrayList 1: " + myList);
        System.out.println("ArrayList 2: " + myList2);
    }
}
