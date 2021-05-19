package com.booking.zoyorooms.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.booking.zoyorooms.entity.Review;
import com.booking.zoyorooms.entity.User;
import com.booking.zoyorooms.repository.ReviewRepository;
import com.booking.zoyorooms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;
    

    @Override
    public ResponseEntity<String> saveUser(User user) {
        User newUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newUser.getUserId()).toUri();
	    return ResponseEntity.created(location).build();
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public ResponseEntity<String> updateUser(User user, Long userId) {

        Optional<User> userOptional = userRepository.findById(userId);
	    if (!userOptional.isPresent())
		    return ResponseEntity.notFound().build();

        user.setUserId(userId);
	    userRepository.save(user);
	    return ResponseEntity.ok().build();
    }


    @Override
    public ResponseEntity<String> deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();
        Optional<List<Review>> reviewOptionalList = reviewRepository.findByUserId(userId);
        if (reviewOptionalList.isPresent()){
            for (Review review : reviewOptionalList.get()) {
                reviewRepository.delete(review);
            }
        }
        userRepository.delete(userOptional.get());
        return ResponseEntity.ok().build();
    }
    
    
}
