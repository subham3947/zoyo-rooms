package com.booking.zoyorooms.service;

import java.util.List;

import com.booking.zoyorooms.entity.User;

import org.springframework.http.ResponseEntity;

public interface UserService {
    
     /**
   * Saves the user into the database and sends HTTP response code.
   * @param user User object for insertion.
   * @return HTTP response code.
   */
    public ResponseEntity<String> saveUser(User User);

     /**
   * Gets the list of all users in the database.
   */
    public List<User> getAllUsers();

    /**
   * Performs update operation for the user into the database and sends HTTP response code.
   * @param user User object for updation.
   * @param userId hotelId to be updated
   * @return HTTP response code.
   */
    public ResponseEntity<String> updateUser(User user, Long userId);

    /**
   * Performs delete operation for the user into the database and sends HTTP response code.
   * @param userId userId to be deleted.
   * @return HTTP response code.
   */
    public ResponseEntity<String> deleteUser(Long userId);
}
