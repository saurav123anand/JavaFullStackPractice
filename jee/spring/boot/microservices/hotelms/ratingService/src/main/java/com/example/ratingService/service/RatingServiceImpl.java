package com.example.ratingService.service;

import com.example.ratingService.entity.Rating;
import com.example.ratingService.exception.RatingNotFoundException;
import com.example.ratingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements IRatingService {
    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        String randomId= UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        rating=repository.save(rating);
        return rating;
    }

    @Override
    public List<Rating> getAll() {
        return repository.findAll();
    }

    @Override
    public Rating findByRatingId(String ratingId) {
        return repository.findById(ratingId).orElseThrow(()->new RatingNotFoundException("Rating not found for ratingId "+ratingId));
    }

    @Override
    public List<Rating> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> findByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
