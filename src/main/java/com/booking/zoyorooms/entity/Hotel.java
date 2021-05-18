package com.booking.zoyorooms.entity;

import java.util.List;

import javax.persistence.Entity;
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
    private long hotelId;

    private String name;

    private String city;

    private int star;

    private int rating;
    
    
}
