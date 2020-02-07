package com.example.demoumbrella.model;

import java.util.List;
import java.util.UUID;

public class FlatInfo {

    private UUID id;
    private List<String> ownerList;
    private List<String> locatorList;
    private String city;
    private String street;
    private String postcode;

    public FlatInfo(UUID id, List<String> ownerList, List<String> locatorList, String city, String street, String postcode) {
        this.id = id;
        this.ownerList = ownerList;
        this.locatorList = locatorList;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public UUID getId() {
        return id;
    }

    public List<String> getOwnerList() {
        return ownerList;
    }

    public List<String> getLocatorList() {
        return locatorList;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }
}
