package com.company.composition.store;

public class VendingMachine {
    private String location;
    private int serial;
    private String model;

    private Chips chips;
    private Chocolate chocolate;
    private Gum gum;
    private Mints mints;
    private Pop pop;
    private Popcorn popcorn;

    public VendingMachine(String location, int serial, String model) {
        this.location = location;
        this.serial = serial;
        this.model = model;
    }

    public String getLocation() {
        return this.location;
    }

    public int getSerial() {
        return this.serial;
    }

    public String getModel() {
        return this.model;
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

    public Gum getGum() {
        return this.gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Mints getMints() {
        return this.mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public Pop getPop() {
        return this.pop;
    }

    public void setPop(Pop pop) {
        this.pop = pop;
    }

    public Popcorn getPopcorn() {
        return this.popcorn;
    }

    public void setPopcorn(Popcorn popcorn) {
        this.popcorn = popcorn;
    }
}
