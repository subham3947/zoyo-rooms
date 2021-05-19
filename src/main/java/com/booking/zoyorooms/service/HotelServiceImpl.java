package com.booking.zoyorooms.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Facility;
import com.booking.zoyorooms.entity.Hotel;
import com.booking.zoyorooms.entity.Reservation;
import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.entity.Room;
import com.booking.zoyorooms.repository.FacilityRepository;
import com.booking.zoyorooms.repository.HotelRepository;
import com.booking.zoyorooms.repository.ReservationRepository;
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

    @Autowired
    ReservationRepository reservationRepository;
    

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


    @Override
    public List<Hotel> getHotelsByFilter(String city, LocalDate checkIn, LocalDate checkOut, Integer guests, Integer star,
            List<String> facilities) {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList = getHotelsWithRoomsAvailable(hotelRepository.findByCityContainingIgnoreCase(city), checkIn, checkOut, guests);
        if (facilities.size() > 0) {
            hotelList = checkForFacilities(facilities, hotelList);
        }
        return hotelList;
    }

    public List<Hotel> getHotelsWithRoomsAvailable(Optional<List<Hotel>> optionalHotelList, LocalDate checkIn,
            LocalDate checkOut, int guests) {
        int totalCapacity = 0;
        List<Hotel> hotelsAvailable = new ArrayList<Hotel>();
        System.out.println(optionalHotelList); 
        if (optionalHotelList.isPresent()) {
            for (Hotel hotel : optionalHotelList.get()) {
                totalCapacity = 0;
                for (Reservation reservation : reservationRepository.findByHotelId(hotel.getHotelId()).get()) {             
                    if( (checkIn.isBefore(reservation.getCheckIn()) && checkOut.isBefore(reservation.getCheckIn())) 
                            || (checkIn.isAfter(reservation.getCheckOut()) && checkIn.isAfter(reservation.getCheckOut()))){
                        totalCapacity += getAvailableCapacity(reservation.getRoomId()); 
                    }
                }
                if (totalCapacity >= guests) {
                    hotelsAvailable.add(hotel);
                }
            }
        }
        return hotelsAvailable;
    }

    public int getAvailableCapacity(Long availableRoomId){
        Optional<Room> room = roomRepository.findById(availableRoomId);
        if (room.isPresent()) {
                return room.get().getCapacity();
        }
        return 0;
    }
    
    public List<Hotel> checkForFacilities(List<String> requiredFacilities, List<Hotel> hotelList) {
        for (Hotel hotel : hotelList) {
            Optional<List<Facility>> optionalFacility = facilityRepository.findByHotelId(hotel.getHotelId());
            if(optionalFacility.isPresent()) {
                Facility hotelFacility = optionalFacility.get().get(0);
                for(int i = 0; i < requiredFacilities.size(); i++) {
                    switch(requiredFacilities.get(i)) {
                        case "wifi":
                          if (!hotelFacility.isWifi())
                            break;
                        case "ac":
                          // code block
                          break;
                        case "meals":
                          // code block
                          break;
                        case "restaurant":
                          // code block
                          break;
                        
                      }
                }
                
            }
        }
        return null;
    }
}
