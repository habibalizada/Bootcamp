package com.trilogy;

import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("------------------------------------------Using Switch Converter------------------------------------------\n");
        System.out.println("Enter a number between 1 and 12 to convert the number to month name: ");
        int monthNUmber = Integer.parseInt(myScanner.nextLine());

        Converter convertMonthSw = new ConverterSwitch();
        System.out.println("The number " + monthNUmber + " is converted to month name, result: " + convertMonthSw.convertMonth(monthNUmber));

        System.out.println("\nEnter a number between 1 and 7 to convert the number to days of a week: ");
        int dayNumber = Integer.parseInt(myScanner.nextLine());

        Converter convertDaySw = new ConverterSwitch();
        System.out.println("The number " + dayNumber + " is converted to day of a week, result: " + convertMonthSw.convertDay(dayNumber));

        System.out.println("\n--------------------------------------------Using If Converter--------------------------------------------\n");
        Converter convertMonthIf = new ConverterIf();
        System.out.println("The number " + monthNUmber + " is converted to month name, result: " + convertMonthIf.convertMonth(monthNUmber));

        Converter convertDayIf = new ConverterIf();
        System.out.println("The number " + dayNumber + " is converted to day of a week, result: " + convertDayIf.convertDay(dayNumber));
    }
}
