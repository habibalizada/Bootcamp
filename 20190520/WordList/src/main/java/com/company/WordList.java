package com.company;

import java.util.ArrayList;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        List<String> myList = new ArrayList<>();
        for (int i = 0; i < wordList.length; i++) {
            myList.add(wordList[i]);
        }

        for(String element : myList) {
            System.out.println(element);
        }


    }

}
