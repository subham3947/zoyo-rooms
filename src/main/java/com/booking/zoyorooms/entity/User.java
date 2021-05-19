package com.booking.zoyorooms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private long userId;

    private String userName;

    private char gender;

    private String city;
}
