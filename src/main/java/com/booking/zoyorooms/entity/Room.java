package com.booking.zoyorooms.entity;

import javax.persistence.Entity;
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
    private long roomId;

    private int capacity;

    private int price;

    private boolean availability;
    
}
