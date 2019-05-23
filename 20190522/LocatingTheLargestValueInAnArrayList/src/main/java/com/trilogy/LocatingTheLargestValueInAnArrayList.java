package com.trilogy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        Random randomGen = new Random();

        for (int i = 0; i < 10; i++) {
            myList.add(randomGen.nextInt(100) + 1);
        }

        System.out.println("ArrayList: " + myList);

        int max = 0;
        int index = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) > max){
                max = myList.get(i);
                index = i;
            }
        }
        System.out.println("The largest value is " + max + ", which is in slot " + index + ".");


    }
}
