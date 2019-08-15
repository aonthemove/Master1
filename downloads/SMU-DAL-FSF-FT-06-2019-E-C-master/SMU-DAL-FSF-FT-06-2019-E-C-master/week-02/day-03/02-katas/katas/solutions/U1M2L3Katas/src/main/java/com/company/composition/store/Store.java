package com.company.composition.store;

public class Store{
    private String name;
    private String address;

    private Chips chips;
    private Pop pop;
    private Chocolate chocolate;

    public Store(String name, String address) {
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

    public Chips getChips() {
        return this.chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public Chocolate getChocolate() {
        return this.chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }
}
