package com.company;

import java.util.Scanner;

public class CarApplication {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Inventory carInventory = new Inventory();

        while(true) {
            System.out.println("Please enter an option: [A]dd, [D]elete, [L]ist, [S]earch, [E]xit");
            String option = scan.nextLine().toLowerCase();

            switch (option) {
                case "add":
                case "a":
                    carInventory.addCar();
                    break;
                case "list":
                case "l":
                    carInventory.listCars();
                    break;
                case "delete":
                case "d":
                    carInventory.deleteCar();
                    break;
                case "search":
                case "s":
                    carInventory.searchCar();
                    break;
                case "exit":
                case "e":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }



    }
}
