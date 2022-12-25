package com.example.hotelService.service;

import com.example.hotelService.entity.Hotel;
import com.example.hotelService.exception.HotelNotFoundException;
import com.example.hotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements IHotelService{
    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId= UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        hotel=repository.save(hotel);
        return hotel;
    }

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public Hotel findByHotelId(String hotelId) {
        return repository.findById(hotelId).orElseThrow(()->new HotelNotFoundException("hotel not found for hotelId "+hotelId));
    }
}
