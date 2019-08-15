package com.company.gameinventory.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer invoiceId;
    @NotNull
    @Size(max=80, message="Name cannot be longer than 80 characters")
    private String name;
    @NotNull
    @Size(max=30, message="Street cannot be longer than 30 characters")
    private String street;
    @NotNull
    @Size(max=20, message="City cannot be longer than 20 characters")
    private String city;
    @NotNull
    @Size(max=20, message="State cannot be longer than 20 characters")
    private String state;
    @NotNull
    @Size(min=5, max=5, message="Zipcode must be exactly 5 digits.")
    private String zipcode;
    @NotNull
    @Size(max=20, message="Item type cannot be longer than 20 characters")
    private String itemType;
    @NotNull
    private Integer itemId;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal subTotal;
    @NotNull
    private BigDecimal tax;
    @NotNull
    private BigDecimal processingFee;
    @NotNull
    private BigDecimal total;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
