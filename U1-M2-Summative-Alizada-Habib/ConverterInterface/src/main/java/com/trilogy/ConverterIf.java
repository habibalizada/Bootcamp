package com.trilogy;

public class ConverterIf implements Converter{

    @Override
    public String convertMonth(int monthNumber) {

        String month ="";

        if (monthNumber >= 1 && monthNumber <= 12 ){
            if (monthNumber == 1){
                month = "January";
            } else if (monthNumber == 2){
                month = "February";
            } else if (monthNumber == 3){
                month = "March";
            } else if (monthNumber == 4){
                month = "April";
            } else if (monthNumber == 5){
                month = "May";
            } else if (monthNumber == 6){
                month = "June";
            } else if (monthNumber == 7){
                month = "July";
            } else if (monthNumber == 8){
                month = "August";
            } else if (monthNumber == 9){
                month = "September";
            } else if (monthNumber == 10){
                month = "October";
            } else if (monthNumber == 11){
                month = "November";
            } else {
                month = "December";
            }

        } else {
            month ="You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }

        return month;
    }

    @Override
    public String convertDay(int dayNumber) {

        String day = "";

        if (dayNumber >= 1 && dayNumber <= 7 ){
            if (dayNumber == 1){
                day = "Sunday";
            } else if (dayNumber == 2){
                day = "Monday";
            } else if (dayNumber == 3){
                day = "Tuesday";
            } else if (dayNumber == 4){
                day = "Wednesday";
            } else if (dayNumber == 5){
                day = "Thursday";
            } else if (dayNumber == 6){
                day = "Friday";
            } else {
                day = "Saturday";
            }

        } else {
            day = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }

        return day;
    }
}
