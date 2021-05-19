package com.booking.zoyorooms.service;

import java.util.List;

import com.booking.zoyorooms.entity.Hotel;

import org.springframework.http.ResponseEntity;

public interface HotelService {
    
    public ResponseEntity<String> saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public ResponseEntity<String> updateHotel(Hotel hotel, Long hotelId);

    public ResponseEntity<String> deleteHotel(long hotelId);
}
