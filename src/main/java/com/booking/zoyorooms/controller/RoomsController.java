package com.booking.zoyorooms.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.booking.zoyorooms.entity.Hotel;
import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.entity.User;
import com.booking.zoyorooms.service.HotelService;
import com.booking.zoyorooms.service.ReviewService;
import com.booking.zoyorooms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoyorooms")
public class RoomsController {

    @Autowired
    HotelService hotelService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;
    
    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/search/hotel/city/{city}/checkIn/{checkIn}/checkOut/{checkOut}")
    public List<Hotel> searchHotels(@PathVariable String city, @PathVariable String checkIn, @PathVariable String checkOut,
            @RequestParam(required=false,defaultValue="1") Integer guests,
            @RequestParam(required=false,defaultValue="1") Integer star,
            @RequestParam(required=false) List<String> facilities){
        // System.out.println(LocalDate.parse(date));
        //System.out.println(facilities);
        return hotelService.getHotelsByFilter(city, LocalDate.parse(checkIn),LocalDate.parse(checkOut), guests, 
            star, facilities);
        }

    @PostMapping("/add/hotel")
    public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
        
    }

    @PutMapping("/update/hotel/{hotelId}")
    public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel, @PathVariable long hotelId){
        return hotelService.updateHotel(hotel, hotelId);
    }

    @DeleteMapping("/delete/hotel/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable long hotelId){
        return hotelService.deleteHotel(hotelId);
    }

    @GetMapping("/showReviews/{hotelId}")
    public Set<Review> getReviews(@PathVariable long hotelId,@RequestParam(required = false) String city,
            @RequestParam(required = false) String rating, @RequestParam(required = false) String gender){
        return reviewService.getHotelReviewByFilters(hotelId, city, rating, gender);
    }

    
    @PostMapping("/add/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PutMapping("/update/user/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable long userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("/add/review")
    public ResponseEntity<String> saveUser(@RequestBody Review review){
        return reviewService.saveReview(review);
    }

    @DeleteMapping("/delete/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable long reviewId){
        return reviewService.deleteReview(reviewId);
    }
}
