package com.booking.zoyorooms.repository;

import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    Optional<List<Review>> findByUserId(Long userId);

    Optional<List<Review>> findByHotelId(long hotelId);

    List<Review> findByRatingAndHotelId(int parseInt, long hotelId);

    Optional<Review> findByUserIdAndHotelId(long userId, long hotelId);

    
}
