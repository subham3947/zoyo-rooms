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
public class Room { 

    @Id
    @GeneratedValue
    private long roomId;

    private long hotelId;

    private int capacity;

    private int price;

    //private boolean available;
    
}
