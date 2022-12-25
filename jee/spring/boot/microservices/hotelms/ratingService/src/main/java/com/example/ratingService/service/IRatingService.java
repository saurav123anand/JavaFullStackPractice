package com.example.ratingService.service;

import com.example.ratingService.entity.Rating;

import java.util.List;

public interface IRatingService {
    Rating create(Rating rating);
    List<Rating> getAll();
    Rating findByRatingId(String ratingId);
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
