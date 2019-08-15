package com.company;

public class Car {

    private String make;
    private String model;
    private int year;
    private String color;
    private int miles;

    public Car() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }


    public void printCarInfo() {
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Year: " + getYear());
        System.out.println("Miles: " + getMiles());
        System.out.println("--------------------------");
    }
}
