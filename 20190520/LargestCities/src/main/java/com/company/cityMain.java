package com.company;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class cityMain {
    public static void main(String[] args) {

        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> cityList = new HashMap<>();

        cityList.put("New York", newYork);
        cityList.put("California", losAngeles);
        cityList.put("Illinois", chicago);
        cityList.put("Colorado", denver);
        cityList.put("Iowa", desMoines);
        cityList.put("Georgia", atlanta);

        DecimalFormat numFormat = new DecimalFormat( "#,###,###,###" );

        System.out.println(" -----------------------------------------------------");
        System.out.println("|     State       |      City       |   Population    |");
        System.out.println(" -----------------------------------------------------");
        for(String keyValue : cityList.keySet()) {
            System.out.format("|  %-15s|  %-15s|  %-15s|%n", keyValue, cityList.get(keyValue).getName(), numFormat.format(cityList.get(keyValue).getPopulation()));
        }
        System.out.println(" -----------------------------------------------------");


        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter minimum population to print the city info: ");
        int population = Integer.parseInt(myScanner.nextLine());

        System.out.println(" -----------------------------------------------------");
        System.out.println("|     State       |      City       |   Population    |");
        System.out.println(" -----------------------------------------------------");
        for(String keyValue : cityList.keySet()) {
            if (cityList.get(keyValue).getPopulation() >= population){
                System.out.format("|  %-15s|  %-15s|  %-15s|%n", keyValue, cityList.get(keyValue).getName(), numFormat.format(cityList.get(keyValue).getPopulation()));
            }
        }
        System.out.println(" -----------------------------------------------------");


    }
}
