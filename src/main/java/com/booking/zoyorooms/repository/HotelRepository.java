package com.booking.zoyorooms.repository;

import com.booking.zoyorooms.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}
