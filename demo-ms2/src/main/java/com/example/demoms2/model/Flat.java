package com.example.demoms2.model;

import java.util.List;
import java.util.UUID;

public class Flat {

    private UUID id;
    private List<UUID> ownerIdList;
    private List<UUID> locatorIdList;
    private String city;
    private String street;
    private String postcode;


    public Flat(UUID id, List<UUID> ownerIdList, List<UUID> locatorIdList, String city, String street, String postcode) {
        this.id = id;
        this.ownerIdList = ownerIdList;
        this.locatorIdList = locatorIdList;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public UUID getId() {
        return id;
    }

    public List<UUID> getOwnerIdList() {
        return ownerIdList;
    }

    public List<UUID> getLocatorIdList() {
        return locatorIdList;
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
