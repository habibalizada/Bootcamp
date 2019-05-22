package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {
            List<Motorcycle> bikes = new CsvToBeanBuilder<Motorcycle>(new FileReader("motorcycles.csv"))
                    .withType(Motorcycle.class).build().parse();

            // Print the information for all Suzuki motorcycles in inventory
            String make = "Suzuki";
            System.out.println("All " + make + " motorcycles in inventory: ");
            bikes
                    .stream()
                    .filter(b -> b.getMake().equals(make))
                    .forEach(bike -> {
                        System.out.println("===============");
                        System.out.println("Make: " + bike.getMake());
                        System.out.println("Model: " + bike.getModel());
                        System.out.println("Color: " + bike.getColor());
                        System.out.println("Year: " + bike.getYear());
                        System.out.println("Displacement: " + bike.getDisplacement());
                        System.out.println("Horsepower: " + bike.getHorsepower());
                        System.out.println("Weight: " + bike.getWeight());
                        System.out.println("Top Speed: " + bike.getTopSpeed());
                    });


            // Get motorcycles with a certain minimum horsepower and return
            // as a collection
            int minHorsepower = 100;
            System.out.println("Get a collection of motorcycles with a minimum hp of " +
                    minHorsepower);
            List<Motorcycle> powerfulBikes =
                    bikes
                            .stream()
                            .filter(b -> b.getHorsepower() > minHorsepower)
                            .collect(Collectors.toList());

            for (Motorcycle moto : powerfulBikes) {
                System.out.println(moto.getMake() + " " + moto.getModel() + " is powerful.");
            }

            //Print the information for all motorcycles the weigh less than 500 pounds
            int weight = 500;
            bikes
                    .stream()
                    .filter(bike -> bike.getWeight() < weight)
                    .forEach(bike -> {
                        System.out.println("===============");
                        System.out.println("Make: " + bike.getMake());
                        System.out.println("Model: " + bike.getModel());
                        System.out.println("Color: " + bike.getColor());
                        System.out.println("Year: " + bike.getYear());
                        System.out.println("Displacement: " + bike.getDisplacement());
                        System.out.println("Horsepwer: " + bike.getHorsepower());
                        System.out.println("Weight: " + bike.getWeight());
                    });

            // Rather than printing out the matching motorcycles, let's put them into a list
            List<Motorcycle> lightBikes =
                    bikes
                            .stream()
                            .filter(bike -> bike.getWeight() < weight)
                            .collect(Collectors.toList());

            System.out.println(lightBikes.size());

            // We can also group our motorcycles by Make.
            System.out.println("================ group motos by make; print makes");
            Map<String, List<Motorcycle>> groupedBikes =
                    bikes
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getMake()));

            Set<String> keys = groupedBikes.keySet();
            for(String key : keys) {
                System.out.println(key);
            }
//
//
//
            System.out.println("XXXXXXX");
            System.out.println("XXXXXXX");

            // Print the average horsepower of the motorcycles in inventory
            double avgHorsepower =
                    bikes
                            .stream()
//                    .filter(b -> b.getMake().equals("Chevrolet"))
                            .mapToInt(b -> b.getHorsepower())
                            .average()
                            .getAsDouble();

            System.out.println("Average horsepower is: " + avgHorsepower);

            int maxHorsePower =
                    bikes
                            .stream()
                            .mapToInt(bike -> bike.getHorsepower())
                            .max()
                            .getAsInt();

            System.out.println("Max horsepower: " + maxHorsePower);


            //print all motorcycle year of 2019
            List<Motorcycle> currentYearBikes =
                    bikes
                            .stream()
                            .filter(bike -> bike.getYear().equals("2019"))
                            .collect(Collectors.toList());

            System.out.println(currentYearBikes.size());
            for (Motorcycle m : currentYearBikes){
                System.out.println(m.getModel() + m.getYear());
            }


            //print all motorcycle year of 2019 average speed
            Double topSpeedAve2019 =
                    bikes
                            .stream()
                            .filter(bike -> bike.getYear().equals("2019"))
                            .mapToInt(bike -> bike.getTopSpeed())
                            .average()
                            .getAsDouble();

            System.out.println("Average top speeds: of 2019 bikes is: " + topSpeedAve2019);








        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }

}