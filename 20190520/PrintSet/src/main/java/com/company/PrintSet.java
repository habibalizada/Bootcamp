package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintSet {
    public static void main(String[] args) {

        Set<Integer> numSet = new HashSet<>();

        numSet.add(5);
        numSet.add(1);
        numSet.add(2);
        numSet.add(1);
        numSet.add(4);
        numSet.add(1);
        numSet.add(5);

        Iterator<Integer> integerIterator = numSet.iterator();

        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next() + ", ");
        }
    }
}
