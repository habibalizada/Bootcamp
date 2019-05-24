package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        System.out.println("------------------Printing the car list from carList ArrayList------------------");
        for (Car car : carList) {
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
            System.out.println("Color: " + car.getColor());
            System.out.println("");
        }

        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);


            writer = new PrintWriter(new FileWriter("cars.json"));

            writer.println(jsonCarList);


        } catch (JsonProcessingException e) {
            System.out.println("Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }



        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Car> carListFromJson;

            carListFromJson = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>(){});

            System.out.println("------------------Printing the car list after reading from JSON file------------------");
            for (Car car : carListFromJson) {
                System.out.println("Make: " + car.getMake());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYear());
                System.out.println("Color: " + car.getColor());
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}
