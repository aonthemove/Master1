package com.company;

import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] userArr = new String[5];

        for (int i = 0; i < userArr.length; i++) {
            System.out.println("Please enter an word.");
            userArr[i] = scan.nextLine();
        }

        for (String word : userArr) {
            System.out.println(word);
        }
    }
}
