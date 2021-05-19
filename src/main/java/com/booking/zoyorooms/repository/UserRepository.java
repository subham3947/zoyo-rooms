package com.booking.zoyorooms.repository;

import java.util.Collection;
import java.util.List;

import com.booking.zoyorooms.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByGender(String gender);

    List<User> findByUserId(String userId);

    Collection<? extends User> findByCity(String city);
    
}
