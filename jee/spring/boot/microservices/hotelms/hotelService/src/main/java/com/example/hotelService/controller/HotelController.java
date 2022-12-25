package com.example.hotelService.controller;

import com.example.hotelService.entity.Hotel;
import com.example.hotelService.service.IHotelService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private IHotelService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Hotel create(@RequestBody Hotel hotel){
        return service.create(hotel);
    }
    @GetMapping("/findbyhotelid/{hotelId}")
    public Hotel findByHotelId(@PathVariable String hotelId){
        return service.findByHotelId(hotelId);
    }
    @GetMapping("/findall")
    public List<Hotel> findAll(){
        return service.findAll();
    }
}
