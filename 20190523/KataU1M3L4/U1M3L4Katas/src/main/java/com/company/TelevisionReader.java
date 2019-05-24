package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisions;

            televisions = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            System.out.println("------------------Printing the car list after reading from JSON file------------------");
            for (Television tv : televisions) {
                System.out.println("Brand: " + tv.getBrand());
                System.out.println("Model: " + tv.getModel());
                System.out.println("Price: " + tv.getPrice());
                System.out.println("Screen Size: " + tv.getScreenSize());
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}
