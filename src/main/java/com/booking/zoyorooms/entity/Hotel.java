package com.booking.zoyorooms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

   
@Entity
public class Hotel {

    @Id
    @GeneratedValue
    private long hotelId;

    private String hotelName;

    private String city;

    private int star;

    // private int rating;
    
    
}
