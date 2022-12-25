package com.example.ratingService.controller;

import com.example.ratingService.entity.Rating;
import com.example.ratingService.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private IRatingService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Rating create(@RequestBody Rating rating){
        return service.create(rating);
    }

    @GetMapping("/findbyratingid/{ratingId}")
    public Rating findByRatingId(@PathVariable String ratingId){
        return service.findByRatingId(ratingId);
    }

    @GetMapping("/findall")
    public List<Rating> findAllRatings(){
        return service.getAll();
    }
    @GetMapping("/users/{userId}")
    public List<Rating> findRatingsByUserId(@PathVariable String userId){
        return service.findByUserId(userId);
    }
    @GetMapping("/hotels/{hotelId}")
    public List<Rating> findRatingsByHotelId(@PathVariable String hotelId){
        return service.findByHotelId(hotelId);
    }
}
