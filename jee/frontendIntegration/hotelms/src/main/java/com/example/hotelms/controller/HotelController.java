package com.example.hotelms.controller;

import com.example.hotelms.entity.Hotel;
import com.example.hotelms.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private IHotelService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public Hotel add(@RequestBody Hotel hotel){
        return service.add(hotel);
    }
    @GetMapping("/findbyid/{id}")
    public Hotel findById(@PathVariable int id){
        return service.findById(id);
    }
    @GetMapping("/findbyname/{name}")
    public Hotel findByName(@PathVariable String name){
        return service.findByName(name);
    }
    @GetMapping("/findall")
    public List<Hotel> findAll(){
        return service.findAll();
    }

}
