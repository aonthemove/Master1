package com.company.gameinventory.viewModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Purchase {

    @NotEmpty(message="You must supply a name for the order")
    private String name;
    @NotEmpty(message="You must supply a street for the order")
    private String street;
    @NotEmpty(message="You must supply a city for the order")
    private String city;
    @NotEmpty(message="You must supply a state for the order")
    private String state;
    @NotEmpty(message="You must supply a zipcode for the order")
    private String zipcode;
    @NotEmpty(message="You must supply a item type for the order")
    private String itemType;
    @Positive(message="Item ID must be greater than 0")
    private int itemId;
    @Positive(message="Quantity must be greater than 0")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
