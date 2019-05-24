package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {

        try {


            List<Computer> computers =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            System.out.println("------------------Printing the car list after reading from CSV file------------------");
            for (Computer computer : computers) {
                System.out.println("Brand: " + computer.getBrand());
                System.out.println("Model: " + computer.getModel());
                System.out.println("CPU: " + computer.getCpu());
                System.out.println("RAM: " + computer.getRam());
                System.out.println("storageSize: " + computer.getStorageSize());
                System.out.println("");
            }


        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }
}
