package com.company;

import java.util.Scanner;

public class MonthConverterIf {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        int number = Integer.parseInt(scan.nextLine());

        String month;

        if (number == 1) {
            month = "January";
        } else if(number == 2) {
            month = "February";
        } else if(number == 3) {
            month = "March";
        } else if(number == 4) {
            month = "April";
        } else if(number == 5) {
            month = "May";
        } else if(number == 6) {
            month = "June";
        } else if(number == 7) {
            month = "July";
        } else if(number == 8) {
            month = "August";
        } else if(number == 9) {
            month = "September";
        } else if(number == 10) {
            month = "October";
        } else if(number == 11) {
            month = "November";
        } else if(number == 12){
            month = "December";
        } else {
            month = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }

        System.out.println(month);

    }
}
