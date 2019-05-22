package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();

        while (myList.size() < 10){
            myList.add(-113);
        }

        while (myList.size() >0){
            System.out.println("Slot "+ (10 - myList.size()) +" contains a " + myList.get(myList.size()-1));
            myList.remove(myList.size()-1);
        }

    }
}
