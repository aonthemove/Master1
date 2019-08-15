package com.company;

import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 10");

        int number = Integer.parseInt(scan.nextLine());


        while (number < 1 || number > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            number = Integer.parseInt(scan.nextLine());
        }

        System.out.println(number);

    }
}
