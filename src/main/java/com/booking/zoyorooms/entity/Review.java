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
public class Review {

    @Id
    @GeneratedValue
    private long reviewId;

    private long hotelId;

    private long userId;

    private int rating;

    private String review;


    
}
