package com.example.userService.service;

import com.example.userService.entities.Hotel;
import com.example.userService.entities.Rating;
import com.example.userService.entities.User;
import com.example.userService.exception.UserNotFoundException;
import com.example.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomId= UUID.randomUUID().toString();
        user.setUserId(randomId);
        user=repository.save(user);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        List<User> users= repository.findAll();
        for(User user:users){
            //String ratingUrl="http://localhost:8085/ratings/users/"+user.getUserId();
            //removing hostname and port
            String ratingUrl="http://RATING-SERVICE/ratings/users/"+user.getUserId();
            Rating[] ratingsOfUser = restTemplate.getForObject(ratingUrl, Rating[].class);
            List<Rating> ratings=Arrays.asList(ratingsOfUser);
            for (Rating rating:ratings){
                //String hotelUrl="http://localhost:8080/hotels/findbyhotelid/"+rating.getHotelId();
                //removing hostname and port
                String hotelUrl="http://HOTEL-SERVICE/hotels/findbyhotelid/"+rating.getHotelId();
                Hotel hotel=restTemplate.getForObject(hotelUrl, Hotel.class);
                rating.setHotel(hotel);
            }
            user.setRatings(ratings);
        }
        return users;
    }

    @Override
    public User findByUserId(String userId) {
        User user= repository.findById(userId).orElseThrow(()->new UserNotFoundException("user not found for userId "+userId));
        //String ratingUrl="http://localhost:8085/ratings/users/"+user.getUserId();
        //removing hostname and port
        String ratingUrl="http://RATING-SERVICE/ratings/users/"+user.getUserId();
        Rating[] ratingsOfUser = restTemplate.getForObject(ratingUrl, Rating[].class);
        List<Rating> ratings=Arrays.asList(ratingsOfUser);
        for (Rating rating:ratings){
            //String hotelUrl="http://localhost:8080/hotels/findbyhotelid/"+rating.getHotelId();
            //removing hostname and port
            String hotelUrl="http://HOTEL-SERVICE/hotels/findbyhotelid/"+rating.getHotelId();
            Hotel hotel=restTemplate.getForObject(hotelUrl, Hotel.class);
            rating.setHotel(hotel);
        }
        user.setRatings(ratings);
        return user;
    }
}
