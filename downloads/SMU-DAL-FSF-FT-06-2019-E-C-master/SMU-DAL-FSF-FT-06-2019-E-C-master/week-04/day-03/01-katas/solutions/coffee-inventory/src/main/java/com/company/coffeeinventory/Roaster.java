package com.company.coffeeinventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="roaster")
public class Roaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roasterId;
    @NotEmpty
    @Length(max=50)
    private String name;
    @NotEmpty
    @Length(max=50)
    private String street;
    @NotEmpty
    @Length(max=50)
    private String city;
    @NotEmpty
    @Length(min=2, max=2)
    private String state;
    @NotEmpty
    @Length(max=25)
    private String postalCode;
    @NotEmpty
    @Length(max=15)
    private String phone;
    @NotEmpty
    @Length(max=60)
    private String email;
    private String note;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToMany(mappedBy = "roasterId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Coffee> coffees;
}
