package com.booking.zoyorooms.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Facility;
import com.booking.zoyorooms.entity.Hotel;
import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.entity.Room;
import com.booking.zoyorooms.repository.FacilityRepository;
import com.booking.zoyorooms.repository.HotelRepository;
import com.booking.zoyorooms.repository.ReviewRepository;
import com.booking.zoyorooms.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    FacilityRepository facilityRepository;
    

    @Override
    public ResponseEntity<String> saveHotel(Hotel hotel) {
        Hotel newHotel = hotelRepository.save(hotel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newHotel.getHotelId()).toUri();
        System.out.println("This URI : " + location);
	    return ResponseEntity.created(location).build();
    }


    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


    @Override
    public ResponseEntity<String> updateHotel(Hotel hotel, Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
	    if (!hotelOptional.isPresent())
		    return ResponseEntity.notFound().build();
        hotel.setHotelId(hotelId);
	    hotelRepository.save(hotel);
	    return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<String> deleteHotel(long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
	    if (!hotelOptional.isPresent())
		    return ResponseEntity.notFound().build();
        //Delete all reviews
        deleteAllReviews(hotelId);
        //Delete all rooms
        deleteAllRooms(hotelId);
        //Delete all facilities
        deleteAllFacilities(hotelId);
        //Finally delete the hotel
        hotelRepository.delete(hotelOptional.get());
        return ResponseEntity.ok().build();
    }

    public void deleteAllReviews(long hotelId){
        Optional<List<Review>> reviewOptionalList = reviewRepository.findByHotelId(hotelId);
        if (reviewOptionalList.isPresent()){
                for (Review review : reviewOptionalList.get()) {
                    reviewRepository.delete(review);
                }
        }
    }

    public void deleteAllRooms(long hotelId){
        Optional<List<Room>> roomOptionalList = roomRepository.findByHotelId(hotelId);
        if (roomOptionalList.isPresent()){
                for (Room room : roomOptionalList.get()) {
                    roomRepository.delete(room);
                }
        }
    }

    public void deleteAllFacilities(long hotelId){
        Optional<List<Facility>> facilityOptionalList = facilityRepository.findByHotelId(hotelId);
        if (facilityOptionalList.isPresent()){
                for (Facility facility : facilityOptionalList.get()) {
                    facilityRepository.delete(facility);
                }
        }
    }
    
}
