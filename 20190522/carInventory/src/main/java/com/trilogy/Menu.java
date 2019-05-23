package com.trilogy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    public static List<Car> carList = new ArrayList<>();
//-----------------------------------------------------------------------------------------------

    public void initiateCars(){
        carList.add(new Car("Toyota", "Camry",2019, "Black", 1200));
        carList.add(new Car("BMW", "X5",2007, "Red", 140000));
        carList.add(new Car("Ford", "F150",1999, "White", 250000));
        carList.add(new Car("Ford", "Mustang",2018, "Black", 5000));
        carList.add(new Car("Toyota", "Corolla",2000, "Blue", 190675));
        carList.add(new Car("Honda", "Civic",1980, "Yellow", 250432));
        carList.add(new Car("BMW", "M3",2017, "Black", 2500));
        carList.add(new Car("Honda", "Accord",2019, "Red", 50000));
        carList.add(new Car("Cadillac", "CTS",2017, "Blue", 3000));
        carList.add(new Car("Cadillac", "CTS-V",2019, "Black", 10));


    }

    public void mainMenu(){

        initiateCars();
//        for (Car c : carList){
//            System.out.println(c);
//        }

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

            //Scanner myScanner = new Scanner(System.in);
            //int userInput = Integer.parseInt(myScanner.nextLine());
            int userInput = getInt();
            while (userInput < 1 || userInput > 5){

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

            //List<Integer> searchResult = new ArrayList();

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



    }

    //-----------------------------------------------------------------------------------------------

    public void listAllCar(){
        for (Car c : carList){
            System.out.println("Index " +carList.indexOf(c)+ ". Make: " + c.getMake() + " Model: " + c.getModel() + " Year: " + c.getYear() + " Color: " + c.getColor() + " Odometer: " + c.getOdometer());
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
        return Integer.parseInt(myScanner.nextLine());
    }

    //-----------------------------------------------------------------------------------------------

    public String getStr(){
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    public boolean confirmDelete(int i){
        System.out.println("Are your sure you want to delete this entry?\n" + carList.get(i) + "\n[Yes, No]");
        String yesNo = getStr();
        if (yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){
            return true;
        } else return false;
    }


}
