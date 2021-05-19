package com.booking.zoyorooms.repository;

import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Facility;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long>{


    Optional<List<Facility>> findByHotelId(long hotelId);
    
}
