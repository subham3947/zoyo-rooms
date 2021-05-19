package com.booking.zoyorooms.repository;

import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    Optional<List<Reservation>> findByHotelId(long hotelId);
    
}
