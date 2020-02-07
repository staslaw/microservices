package com.example.demoms2.model;

import com.example.demoms2.exceptions.IncorrectDataException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="postCode")
    private String postCode;

    //annotations from javax.validation.constraints don't work in embedded object

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void validate() throws IncorrectDataException {
        if (this.city == null || this.city.isEmpty() ||
        this.street == null || this.street.isEmpty() ||
        this.postCode == null || this.postCode.isEmpty()) {
            throw new IncorrectDataException("Same fields of Address are null or empty");
        }
    }
}
