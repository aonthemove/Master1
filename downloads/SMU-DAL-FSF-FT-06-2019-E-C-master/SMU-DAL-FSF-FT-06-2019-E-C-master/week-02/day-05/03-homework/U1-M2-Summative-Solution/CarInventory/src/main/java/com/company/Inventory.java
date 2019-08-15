package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Car> carList;
    private Scanner scan;

    public Inventory() {
        carList = new ArrayList<>();
        scan = new Scanner(System.in);
    }

    private String getInput(String prompt) {

        System.out.println(prompt);
        return scan.nextLine();
    }

    public void addCar() {

        Car newCar = new Car();

        newCar.setMake(getInput("Make: "));
        newCar.setModel(getInput("Model: "));
        newCar.setColor(getInput("Color: "));

        boolean success = false;

        while(!success) {
            try {
                newCar.setYear(Integer.parseInt(getInput("Year: ")));
                success = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please input only numbers");
            }
        }

        success = false;
        while(!success) {
            try {
                newCar.setMiles(Integer.parseInt(getInput("Miles: ")));
                success = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please input only numbers");
            }
        }

        carList.add(newCar);
    }

    public void deleteCar() {

        listCars();

        boolean success = false;

        while(!success) {
            try {
                carList.remove(Integer.parseInt(getInput("Enter the index of the car you wish to delete.")));
                success = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please input a valid index.");
            }
        }
    }

    public void searchCar() {

        boolean success = false;

        while (!success) {
            String property =  getInput("Please enter a search field: [M]ake, M[o]del, [C]olor, [Y]ear, M[i]les, [A]bort")
                    .toLowerCase();

            String value;

            try {
                switch (property) {
                    case "model":
                    case "o":
                        value = getInput("Enter a value to search for.")
                                .toLowerCase();
                        carList.stream()
                                .filter(car -> car.getModel().toLowerCase().equals(value))
                                .forEach(car -> car.printCarInfo());
                        success = true;
                        break;
                    case "make":
                    case "m":
                        value = getInput("Enter a value to search for.")
                                .toLowerCase();
                        carList.stream()
                                .filter(car -> car.getMake().toLowerCase().equals(value))
                                .forEach(car -> car.printCarInfo());
                        success = true;
                        break;
                    case "color":
                    case "c":
                        value = getInput("Enter a value to search for.")
                                .toLowerCase();
                        carList.stream()
                                .filter(car -> car.getColor().toLowerCase().equals(value))
                                .forEach(car -> car.printCarInfo());
                        success = true;
                        break;
                    case "year":
                    case "y":
                        value = getInput("Enter a value to search for.");
                        carList.stream()
                                .filter(car -> car.getYear() == Integer.parseInt(value))
                                .forEach(car -> car.printCarInfo());
                        success = true;
                        break;
                    case "miles":
                    case "i":
                        value = getInput("Enter a value to search for.");
                        carList.stream()
                                .filter(car -> car.getMiles() < Integer.parseInt(value))
                                .forEach(car -> car.printCarInfo());
                        success = true;
                        break;
                    case "abort":
                    case "a":
                        success = true;
                        break;
                    default:
                        System.out.println("Invalid search option.");
                }
            } catch (Exception e) {
                System.out.println("Please check your inputs and try again.");
            }

        }

    }

    public void listCars() {

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.println("Index: " +  i);
            car.printCarInfo();
        }
    }
}
