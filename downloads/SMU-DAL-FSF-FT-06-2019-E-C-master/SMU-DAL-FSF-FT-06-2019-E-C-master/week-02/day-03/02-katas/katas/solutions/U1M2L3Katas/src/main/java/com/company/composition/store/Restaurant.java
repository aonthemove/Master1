package com.company.composition.store;

public class Restaurant {
    private String name;
    private String address;

    private Pop pop;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Pop getPop() {
        return this.pop;
    }

    public void setPop(Pop pop) {
        this.pop = pop;
    }
}
