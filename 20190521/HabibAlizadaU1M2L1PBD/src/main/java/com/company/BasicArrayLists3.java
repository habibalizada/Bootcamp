package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        Random randomGen = new Random();

        for (int i = 0; i < 1000; i++) {
            myList.add(randomGen.nextInt(89) + 10);
        }

        int newLine = 1;
        for (int myInt : myList){
            System.out.print(myInt + ", ");
            if (newLine % 20 == 0){
                System.out.println();
            }
            newLine++;

        }
    }
}
