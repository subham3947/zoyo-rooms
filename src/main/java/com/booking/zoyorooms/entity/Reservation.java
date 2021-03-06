package com.booking.zoyorooms.entity;

import java.time.LocalDate;

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
public class Reservation {
    
    @Id
    @GeneratedValue
    private long reservationId;

    private long hotelId;
    
    private long roomId;

    private long userId;

    private LocalDate checkIn;

    private LocalDate checkOut;
}
