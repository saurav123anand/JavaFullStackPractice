package com.example.hotelms.service;

import com.example.hotelms.entity.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel add(Hotel hotel);
    Hotel findById(int id);
    Hotel findByName(String name);
    List<Hotel> findAll();
}
