package com.booking.zoyorooms.service;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.entity.User;
import com.booking.zoyorooms.repository.ReviewRepository;
import com.booking.zoyorooms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ReviewServiceImpl implements ReviewService{


    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;
    

    @Override
    public ResponseEntity<String> saveReview(Review review) {
        Review newReview = reviewRepository.save(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newReview.getReviewId()).toUri();
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


    @Override
    public List<Review> getHotelReview(long hotelId) {
        Optional<List<Review>> reviewOptional = reviewRepository.findByHotelId(hotelId);
	    return reviewOptional.get();
    }


    @Override
    public Set<Review> getHotelReviewByFilters(long hotelId, String city, String rating, String gender) {
        Set<Review> reviewSet = new HashSet<Review>();
        Set<User> users = new HashSet<User>();
        if (rating != null)
            reviewSet.addAll(reviewRepository.findByRatingAndHotelId(Integer.parseInt(rating), hotelId));
        if (city != null)
            users.addAll(userRepository.findByCity(city));
        if (gender != null)
            users.addAll(userRepository.findByGender(gender));
        for(User user : users) {
            Optional<Review> optionalReview = reviewRepository.findByUserIdAndHotelId(user.getUserId(), hotelId);
            if (optionalReview.isPresent())
            reviewSet.add(optionalReview.get());
        }
        if (reviewSet.size() == 0)
            reviewSet.addAll(reviewRepository.findByHotelId(hotelId).get());
        System.out.println(reviewSet);
        return reviewSet;
    }
    
    
    
}
