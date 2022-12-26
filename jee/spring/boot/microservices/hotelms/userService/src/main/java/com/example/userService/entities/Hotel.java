package com.example.userService.entities;

public class Hotel {
    private String hotelId;
    private String hotelName;
    private String location;
    private String about;

    public Hotel() {
    }

    public Hotel(String hotelId, String hotelName, String location, String about) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.about = about;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
