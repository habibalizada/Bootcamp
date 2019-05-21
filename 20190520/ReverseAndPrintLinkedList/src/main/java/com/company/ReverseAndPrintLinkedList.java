package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseAndPrintLinkedList {
    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        List<Integer> numList = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(numbers[i]);
        }

        System.out.println("--------------");
        System.out.println("Normal");
        System.out.println("--------------");

        for(int element : numList) {
            System.out.println(element);
        }

        Collections.reverse(numList);

        System.out.println("--------------");
        System.out.println("Reversed");
        System.out.println("--------------");

        for(int element : numList) {
            System.out.println(element);
        }
    }
}
