package com.booking.zoyorooms.service;

import java.time.LocalDate;
import java.util.List;

import com.booking.zoyorooms.entity.Hotel;

import org.springframework.http.ResponseEntity;

public interface HotelService {
    
    public ResponseEntity<String> saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public ResponseEntity<String> updateHotel(Hotel hotel, Long hotelId);

    public ResponseEntity<String> deleteHotel(long hotelId);

    public List<Hotel> getHotelsByFilter(String city, LocalDate checkIn, LocalDate checkOut, Integer guests, Integer star,
            List<String> facilities);
}
