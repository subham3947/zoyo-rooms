package com.booking.zoyorooms.repository;

import com.booking.zoyorooms.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
