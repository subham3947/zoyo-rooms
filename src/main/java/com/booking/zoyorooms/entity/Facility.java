package com.booking.zoyorooms.entity;

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
public class Facility {
    
    @Id
    private long hotelId;

    private boolean ac;

    private boolean wifi;

    private boolean meals;

    private boolean restaurant;
}
