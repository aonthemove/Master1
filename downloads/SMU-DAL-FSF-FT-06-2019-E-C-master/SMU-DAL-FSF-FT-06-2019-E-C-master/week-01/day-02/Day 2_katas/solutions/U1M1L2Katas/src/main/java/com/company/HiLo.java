package com.company;

import java.util.Scanner;

public class HiLo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input < 10){
            System.out.println("Low");
        } else {
            System.out.println("Hi");
        }
    }
}
