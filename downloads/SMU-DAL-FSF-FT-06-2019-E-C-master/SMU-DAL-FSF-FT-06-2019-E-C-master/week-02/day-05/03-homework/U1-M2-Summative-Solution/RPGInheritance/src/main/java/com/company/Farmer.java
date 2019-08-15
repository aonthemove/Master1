package com.company;

public class Farmer extends Character {

    public Farmer(String name) {
        super(name, 75, 100, 75, 10, 1);
    }

    public void plow() {
        System.out.println("Work, work, work...");
    }

    public void harvest() {
        System.out.println("Hi-ho, hi-ho. It's off to the silo we go!");
    }
}
