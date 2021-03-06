package com.booking.zoyorooms.service;

import java.util.List;
import java.util.Set;

import com.booking.zoyorooms.entity.Review;

import org.springframework.http.ResponseEntity;

public interface ReviewService {
    
    public ResponseEntity<String> saveReview(Review Review);

    public List<Review> getAllReviews();

    public ResponseEntity<String> updateReview(Review Review, Long ReviewId);

    public ResponseEntity<String> deleteReview(long reviewId);

    public List<Review> getHotelReview(long hotelId);

    public Set<Review> getHotelReviewByFilters(long hotelId, String city, String rating, String gender);
}
