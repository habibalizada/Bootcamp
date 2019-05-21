package com.company;

import java.util.ArrayList;
import java.util.List;

public class Total {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        int total = 0;

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(numbers[i]);
        }

        for(int element : numList) {
            total += element;
        }

        System.out.println("The sum of all elements in the array is " + total);

    }

}
