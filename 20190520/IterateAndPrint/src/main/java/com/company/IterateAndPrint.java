package com.company;

import java.util.*;

public class IterateAndPrint {

    public static void main(String[] args) {

        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");

        Set<String> myKeys = baseballTeam.keySet();
        System.out.println("\nHere is the keys in the baseballTeam map: ");
        for (String key: myKeys) {
            System.out.println(key);
        }

        System.out.println("\nHere is the values in the baseballTeam:");
        Collection<String> allTheBaseballTeamValues = baseballTeam.values();
        for (String theMovie : allTheBaseballTeamValues) {
            System.out.println(theMovie);
        }

        System.out.println("\nHere is both the keys and values in the baseballTeam: ");
        for(String keyValue : baseballTeam.keySet()) {
            System.out.println("Key: " + keyValue + ", Value: " + baseballTeam.get(keyValue));
        }

    }

}
