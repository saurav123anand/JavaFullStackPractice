package com.example.studentms.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    private int addressId;
    private String street;
    private String city;
    //removing One to one to make it uni-directional
    //@OneToOne(mappedBy = "address",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@Transient
    //private Student student;

    public Address() {
    }

    public Address(int addressId, String street, String city) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
}
