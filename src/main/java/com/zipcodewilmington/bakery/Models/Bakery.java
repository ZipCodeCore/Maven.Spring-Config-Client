package com.zipcodewilmington.bakery.Models;

import org.springframework.stereotype.Component;

@Component
public class Bakery {
    private String owner;

    private String name;

    private String address;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
