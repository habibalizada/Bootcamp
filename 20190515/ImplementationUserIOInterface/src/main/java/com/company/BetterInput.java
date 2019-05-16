package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {

    Scanner myScanner = new Scanner(System.in);



    @Override
    public int readInt(String prompt) {
        int userInput =0;
        try {
            System.out.println(prompt);
            userInput = Integer.parseInt(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            readInt(prompt);
        }
        return userInput;
    }

    @Override
    public long readLong(String prompt) {

        Long userInput =0L;
        try {
            System.out.println(prompt);
            userInput = Long.parseLong(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            readInt(prompt);
        }
        return userInput;
    }

    @Override
    public double readDouble(String prompt) {
        Double userInput =0.0;
        try {
            System.out.println(prompt);
            userInput = Double.parseDouble(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            readInt(prompt);
        }
        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        Float userInput =0f;
        try {
            System.out.println(prompt);
            userInput = Float.parseFloat(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            readInt(prompt);
        }
        return userInput;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return myScanner.nextLine();
    }
}
