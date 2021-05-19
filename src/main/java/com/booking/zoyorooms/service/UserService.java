package com.booking.zoyorooms.service;

import java.util.List;

import com.booking.zoyorooms.entity.User;

import org.springframework.http.ResponseEntity;

public interface UserService {
    
    public ResponseEntity<String> saveUser(User User);

    public List<User> getAllUsers();

    public ResponseEntity<String> updateUser(User User, Long UserId);

    public ResponseEntity<String> deleteUser(Long UserId);
}
