package com.booking.zoyorooms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomsController {

    @GetMapping("/hotel")
    public String getHotel(){
        return "Trivago";
    }
    
}
