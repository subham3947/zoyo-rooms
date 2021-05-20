package com.booking.zoyorooms.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import com.booking.zoyorooms.entity.Hotel;

import org.springframework.http.ResponseEntity;

public interface HotelService {
    
    /**
   * Saves the hotel into the database and sends HTTP response code.
   * @param hotel Hotel object for insertion.
   * @return HTTP response code.
   */
    public ResponseEntity<String> saveHotel(Hotel hotel);

    /**
   * Gets the list of all hotels in the database.
   */
    public List<Hotel> getAllHotels();

    /**
   * Performs update operation for the hotel into the database and sends HTTP response code.
   * @param hotel Hotel object for updation.
   * @param hotelId hotelId to be updated
   * @return HTTP response code.
   */
    public ResponseEntity<String> updateHotel(Hotel hotel, Long hotelId);

     /**
   * Performs delete operation for the hotel into the database and sends HTTP response code.
   * @param hotel Hotel object for updation.
   * @param hotelId hotelId to be deleted.
   * @return HTTP response code.
   */
    public ResponseEntity<String> deleteHotel(long hotelId);

     /**
   * Gets list of hotels by the filters specified in the query.
   * @param city City for the hotel booking.
   * @param checkIn Date when the reservation starts.
   * @param checkOut Date when the reservation ends.
   * @param guests Number of persons.
   * @param star Star of the hotel.
   * @param facilities List of facilities Hotel should have.
   * @return Hashset of hotel qualifying all criterias.
   */
    public HashSet<Hotel> getHotelsByFilter(String city, LocalDate checkIn, LocalDate checkOut, Integer guests, Integer star,
            List<String> facilities);
}
