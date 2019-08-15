package com.company.coffeeinventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffeeId;
    @NotNull
    private Integer roasterId;
    @NotEmpty
    @Length(max=50)
    private String name;
    @NotNull
    private Integer count;
    @NotNull
    private Float unitPrice;
    private String description;
    @Length(max=50)
    private String type;


    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(Integer roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
