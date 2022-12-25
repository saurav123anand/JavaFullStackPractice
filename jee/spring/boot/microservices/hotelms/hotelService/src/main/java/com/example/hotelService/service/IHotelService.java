package com.example.hotelService.service;

import com.example.hotelService.entity.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel create(Hotel hotel);
    List<Hotel> findAll();
    Hotel findByHotelId(String hotelId);
}
