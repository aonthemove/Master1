package com.company;

public class Motorcycle extends Vehicle {
    private int cubicCentimeters;

    public void drive(int miles) {
        if( isRunning() ){
            this.setMilesTraveled( this.getMilesTraveled() + miles );
        }
    }

    public void displayMilesTraveled() {
        System.out.println(this.getMilesTraveled() + " miles have been cruised on this hog");
    }

    public boolean isRunning() {
        return false;
    }

    public void repair() {
        System.out.println("Repairing....again...");
    }

    public int getCubicCentimeters() {
        return cubicCentimeters;
    }

    public void setCubicCentimeters(int cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }
}
