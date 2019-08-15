package com.company.composition.laptop;

public class Laptop {
    private String manufacturer;
    private String model;

    private Processor processor;
    private Memory memory;
    private OpticalDrive opticalDrive;

    public Laptop(String manufacturer, String model, Processor processor, Memory memory, OpticalDrive opticalDrive) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.opticalDrive = opticalDrive;
    }

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

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }
}
