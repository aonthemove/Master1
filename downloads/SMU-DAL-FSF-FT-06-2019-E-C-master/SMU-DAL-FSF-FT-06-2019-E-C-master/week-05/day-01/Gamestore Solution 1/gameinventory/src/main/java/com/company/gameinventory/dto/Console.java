package com.company.gameinventory.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="console")
public class Console {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer consoleId;
    @NotNull
    @Size(max=50, message="Model cannot be longer than 50 characters")
    private String model;
    @NotNull
    @Size(max=50, message="Manufacturer cannot be longer than 50 characters")
    private String manufacturer;
    @Size(max=20, message="Memory amount cannot be longer than 20 characters")
    private String memoryAmount;
    @Size(max=20, message="Processor cannot be longer than 20 characters")
    private String processor;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;

    public Integer getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(Integer consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
