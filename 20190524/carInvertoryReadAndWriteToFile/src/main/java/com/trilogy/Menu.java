package com.trilogy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    public static List<Car> carList = new ArrayList<>();

    public void mainMenu(){

        listAllCar(); // Displaying all car to the screen

        System.out.println("Welcome to Car Inventory");

        boolean exit = false;

        while (!exit){

            System.out.println("\nMain menu");
            System.out.println("1. Add a car to inventory");
            System.out.println("2. Delete a car from inventory");
            System.out.println("3. List all cars in inventory");
            System.out.println("4. Search cars");
            System.out.println("5. Exit");
            System.out.println("Select Menu Number [1-5]:");

            int userInput = getInt();

            while (userInput < 1 || userInput > 5 ){

                System.out.println("\nMain menu");
                System.out.println("1. Add a car to inventory");
                System.out.println("2. Delete a car from inventory");
                System.out.println("3. List all cars in inventory");
                System.out.println("4. Search cars");
                System.out.println("5. Exit");
                System.out.println("\nYour selection is not in the menu!");
                System.out.println("Select Menu Number [1-5]:");

                userInput = getInt();
            }

            switch (userInput){
                case 1:
                    addCar();
                    break;
                case 2:
                    deleteCar();
                    break;
                case 3:
                    listAllCar();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    exit = true;
            }

        }

    }

    //-----------------------------------------------------------------------------------------------

    public void addCar(){

        Car newCar = new Car();
        System.out.println("Enter car's Make: ");
        newCar.setMake(getStr());
        System.out.println("Enter car's Model: ");
        newCar.setModel(getStr());
        System.out.println("Enter car's Year of production: ");
        newCar.setYear(getInt());
        System.out.println("Enter car's Color");
        newCar.setColor(getStr());
        System.out.println("Enter car's Odometer");
        newCar.setOdometer(getInt());
        carList.add(newCar);
        System.out.print("Make: " + newCar.getMake() + " Model: " + newCar.getModel() + " Year: " + newCar.getYear() + " Color: " + newCar.getColor() + " Odometer: " + newCar.getOdometer());
        System.out.println(" is added.");

        save();

    }

    //-----------------------------------------------------------------------------------------------

    public void deleteCar(){
        List<Car> listOfCarToDelete = new ArrayList<>();
        System.out.println("Delete Menu");
        System.out.println("Enter car's make:");
        String carToDelete = getStr();
        listOfCarToDelete =
                carList
                        .stream()
                        .filter(car -> car.getMake().equalsIgnoreCase(carToDelete))
                        .collect(Collectors.toList());

        for (Car c: listOfCarToDelete){
            System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
        }
        System.out.println("Enter the index of a car to delete:");
        int indexToDelete = getInt();
        if (confirmDelete(indexToDelete)){
            carList.remove(indexToDelete);
            System.out.println("The entry is deleted.");
        }else {
            System.out.println("No information is deleted");
        }
        save();//Saving to the file

    }

    //-----------------------------------------------------------------------------------------------

    public void listAllCar(){
        try {
            ObjectMapper mapper = new ObjectMapper();

            carList = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>(){});

            System.out.println(" ---------------------------------------------------------------------- ");
            System.out.println("| Index |     Make     |    Model  |    Year   |    Color  |  Odometer |");
            System.out.println("|-------+--------------+-----------+-----------+-----------+-----------|");
            for (Car c : carList){
                System.out.printf("| %-6s| %-13s| %-10s| %-10s| %-10s| %-10s|%n" ,carList.indexOf(c), c.getMake(), c.getModel(), c.getYear(), c.getColor(), c.getOdometer() );
                //System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());

            }
            System.out.println(" ---------------------------------------------------------------------- ");

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }

    //-----------------------------------------------------------------------------------------------

    public void search(){
        List<Car> searchResul = new ArrayList<>();

        System.out.println("\nSearch Menu");
        System.out.println("1. Search by Make");
        System.out.println("2. Search by Model");
        System.out.println("3. Search by year");
        System.out.println("4. Search by color");
        System.out.println("5. Search by minimum Mileage");
        int menuChose = getInt();
        if (menuChose == 1){
            System.out.println("Enter Make: ");
            String userInputMake = getStr();
            searchResul =
                    carList
                            .stream()
                            .filter(car -> car.getMake().equalsIgnoreCase(userInputMake))
                            .collect(Collectors.toList());

            for (Car c : searchResul){
                System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
            }


        }else if(menuChose == 2){
            System.out.println("Enter Model: ");
            String userInputModel = getStr();
            searchResul =
                    carList
                            .stream()
                            .filter(car -> car.getModel().equalsIgnoreCase(userInputModel))
                            .collect(Collectors.toList());

            for (Car c : searchResul){
                System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
            }

        } else if (menuChose == 3){
            System.out.println("Enter year: ");
            int userInputYear = getInt();
            searchResul =
                    carList
                            .stream()
                            .filter(car -> car.getYear() == userInputYear)
                            .collect(Collectors.toList());

            for (Car c : searchResul){
                System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
            }
        } else if (menuChose == 4){
            System.out.println("Enter Color: ");
            String userInputColor = getStr();
            searchResul =
                    carList
                            .stream()
                            .filter(car -> car.getColor().equalsIgnoreCase(userInputColor))
                            .collect(Collectors.toList());

            for (Car c : searchResul){
                System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
            }
        } else if (menuChose == 5){
            System.out.println("Enter minimum mileage: ");
            int userInputOdometer = getInt();
            searchResul =
                    carList
                            .stream()
                            .filter(car -> car.getOdometer() >= userInputOdometer)
                            .collect(Collectors.toList());

            for (Car c : searchResul){
                System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
            }
        }


    }

    //-----------------------------------------------------------------------------------------------

    public int getInt(){

        Scanner myScanner = new Scanner(System.in);
        String returnValue =myScanner.nextLine();
        while (!isNumber(returnValue)){
            System.out.println("Enter a number!");
            returnValue =myScanner.nextLine();
        }

        return Integer.parseInt(returnValue);
    }

    //-----------------------------------------------------------------------------------------------

    public String getStr(){
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }
    //-----------------------------------------------------------------------------------------------
    static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i))
                    == false)
                return false;

        return true;
    }
    //-----------------------------------------------------------------------------------------------

    public boolean confirmDelete(int i){
        System.out.println("Are your sure you want to delete this entry?\n" + carList.get(i) + "\n[Yes, No]");
        String yesNo = getStr();
        if (yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){
            return true;
        } else return false;
    }



    //-----------------------------------------------------------------------------------------------

    public void save(){
        PrintWriter writer = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String valueAsString = mapper.writeValueAsString(carList);

            writer = new PrintWriter(new FileWriter("cars.json"));

            writer.println(valueAsString);


        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }


}
