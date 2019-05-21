package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmateMain {
    public static void main(String[] args) {

        List<Classmate> classmateList = new ArrayList<>();

        Classmate tri = new Classmate("Tri","Black");
        Classmate ken = new Classmate("Ken","Black");
        Classmate zhamal = new Classmate("Zhamal","Brown");
        Classmate nurgul = new Classmate("Nurgul","Blond");
        Classmate ezra = new Classmate("Ezra","Brown");

        classmateList.add(tri);
        classmateList.add(ken);
        classmateList.add(zhamal);
        classmateList.add(nurgul);
        classmateList.add(ezra);

        for (Classmate classmate : classmateList){
            System.out.println(classmate);
        }
    }
}
