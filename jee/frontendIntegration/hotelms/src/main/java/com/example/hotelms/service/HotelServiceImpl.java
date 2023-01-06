package com.example.hotelms.service;

import com.example.hotelms.entity.Hotel;
import com.example.hotelms.exception.HotelNotFoundException;
import com.example.hotelms.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{
    @Autowired
    private HotelRepository repository;
    @Override
    public Hotel add(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel findById(int id) {
        return repository.findById(id).orElseThrow(()->new HotelNotFoundException("hotel not found for id "+id));
    }

    @Override
    public Hotel findByName(String name) {
        return repository.findByName(name).orElseThrow(()->new HotelNotFoundException("hotel not found for name "+name));
    }

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }
}
