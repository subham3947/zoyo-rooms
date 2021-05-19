package com.booking.zoyorooms.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ReviewServiceImpl implements ReviewService{


    @Autowired
    ReviewRepository reviewRepository;
    

    @Override
    public ResponseEntity<String> saveReview(Review review) {
        Review newReview = reviewRepository.save(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newReview.getReviewId()).toUri();
        //System.out.println("This URI : " + location);
	    return ResponseEntity.created(location).build();
    }


    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


    @Override
    public ResponseEntity<String> updateReview(Review review, Long reviewId) {

        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
	    if (!reviewOptional.isPresent())
		    return ResponseEntity.notFound().build();

            review.setReviewId(reviewId);
	    reviewRepository.save(review);
	    return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<String> deleteReview(long reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
	    if (!reviewOptional.isPresent())
		    return ResponseEntity.notFound().build();

        reviewRepository.delete(reviewOptional.get());
	    return ResponseEntity.ok().build();
    }
    
    
}
