package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SwapAndPrintLinkedList {
    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        List<Integer> numList = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(numbers[i]);
        }

        System.out.println("----------------");
        System.out.println("Original Array");

        for(int element : numList) {
            System.out.println(element);
        }

        int temp = numList.get(0);
        numList.set(0,numList.get(numList.size()-1));
        numList.set(numList.size()-1,temp);

        System.out.println("----------------");
        System.out.println("Swapped Array");

        for(int element : numList) {
            System.out.println(element);
        }

    }
}
