package com.booking.zoyorooms.repository;

import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

    //Optional<List<Hotel>> findByCity(String city);

    Optional<List<Hotel>> findByCityContainingIgnoreCase(String city);
    
}
