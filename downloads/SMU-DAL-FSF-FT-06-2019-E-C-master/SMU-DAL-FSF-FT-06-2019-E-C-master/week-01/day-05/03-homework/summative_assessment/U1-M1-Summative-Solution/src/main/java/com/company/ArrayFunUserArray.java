package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] userArr = new int[5];

        for (int i = 0; i < userArr.length; i++) {
            System.out.println("Please enter an integer.");
            userArr[i] = Integer.parseInt(scan.nextLine());
        }

        for (int num : userArr) {
            System.out.println(num);
        }
    }
}
