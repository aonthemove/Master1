package com.company;

import java.io.*;
import java.util.Scanner;

public class FileFun {

    public static void main(String[] args) throws IOException {

        // Gather user input and put in an array
        Scanner consoleScanner = new Scanner(System.in);

        String[] userArr = new String[5];

        for (int i = 0; i < userArr.length; i++) {
            System.out.println("Please enter an word.");
            userArr[i] = consoleScanner.nextLine();
        }

        // Write the input to the file
        PrintWriter out = new PrintWriter(new FileWriter("word-file.txt", true));

        for (String input : userArr) {
            out.println(input);
        }

        out.flush();
        out.close();

        // Read the file and print to the screen
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("word-file.txt")));

        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine();
            System.out.println(currentLine);
        }

        fileScanner.close();
    }
}
