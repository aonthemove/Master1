package com.company.composition.laptop;

public class OpticalDrive {
    private String manufacturer;
    private String model;
    private boolean open;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void toggle() {
        if(this.open) {
            this.open = false;
        } else {
            this.open = true;
        }
    }
}
