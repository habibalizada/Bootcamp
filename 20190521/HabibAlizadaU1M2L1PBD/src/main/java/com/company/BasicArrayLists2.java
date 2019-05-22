package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        Random randomGen = new Random();

        for (int i = 0; i < 10; i++) {
            myList.add(randomGen.nextInt(100) + 1);
        }

        System.out.println("ArrayList: " + myList);

    }
}
