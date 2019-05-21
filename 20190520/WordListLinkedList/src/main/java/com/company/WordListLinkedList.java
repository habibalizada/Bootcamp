package com.company;

import java.util.LinkedList;
import java.util.List;

public class WordListLinkedList {
    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        List<String> myList = new LinkedList<>();
        for (int i = 0; i < wordList.length; i++) {
            myList.add(wordList[i]);
        }

        for(String element : myList) {
            System.out.println(element);
        }


    }
}
