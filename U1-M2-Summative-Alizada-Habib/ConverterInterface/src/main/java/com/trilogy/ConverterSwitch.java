package com.trilogy;

public class ConverterSwitch implements Converter {

    @Override
    public String convertMonth(int monthNumber) {

        String month ="";

        if (monthNumber >= 1 && monthNumber <= 12 ){

            switch (monthNumber){
                case 1:
                    month = "January";
                    break;
                case 2:
                    month = "February";
                    break;
                case 3:
                    month = "March";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "June";
                    break;
                case 7:
                    month = "July";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "September";
                    break;
                case 10:
                    month = "October";
                    break;
                case 11:
                    month = "November";
                    break;
                case 12:
                    month = "December";
                    break;
            }

        } else {
            month = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }

        return month;
    }

    @Override
    public String convertDay(int dayNumber) {

        String day ="";

        if (dayNumber >= 1 && dayNumber <= 7 ){

            switch (dayNumber){
                case 1:
                    day = "Sunday";
                    break;
                case 2:
                    day = "Monday";
                    break;
                case 3:
                    day = "Tuesday";
                    break;
                case 4:
                    day = "Wednesday";
                    break;
                case 5:
                    day = "Thursday";
                    break;
                case 6:
                    day = "Friday";
                    break;
                case 7:
                    day = "Saturday";
                    break;
            }

        } else {
            day = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }
        return day;
    }
}
