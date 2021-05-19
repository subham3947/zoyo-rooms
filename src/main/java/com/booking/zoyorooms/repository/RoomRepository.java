package com.booking.zoyorooms.repository;

import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>{

    Optional<List<Room>> findByHotelId(long hotelId);
    
}
