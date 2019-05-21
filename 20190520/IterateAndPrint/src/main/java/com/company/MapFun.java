package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapFun {
    public static void main(String[] args) {

        Map<String, Integer> carList = new HashMap<>();

        carList.put("Toyota Camry",2012);
        carList.put("Chevy Camaro",1969);
        carList.put("Hyundai Genesis",2015);
        carList.put("Jeep Wrangler",2003);
        carList.put("Honda Civic",2018);
        carList.put("Toyota Supra",1995);
        carList.put("Pontiac GTO",1964);

        System.out.println("\nHere is both the keys and values in the carList: ");
        for(String keyValue : carList.keySet()) {
            System.out.println("Key: " + keyValue + ", Value: " + carList.get(keyValue));
        }

        carList.put("Ford Explorer",2012);
        carList.put("Smart Fortwo",2013);

        System.out.println("\nHere is both the keys and values in the carList after adding two values: ");
        for(String keyValue : carList.keySet()) {
            System.out.println("Key: " + keyValue + ", Value: " + carList.get(keyValue));
        }

        carList.remove("Jeep Wrangler");

        System.out.println("\nHere is both the keys and values in the carList after removing one value: ");
        for(String keyValue : carList.keySet()) {
            System.out.println("Key: " + keyValue + ", Value: " + carList.get(keyValue));
        }

    }
}
