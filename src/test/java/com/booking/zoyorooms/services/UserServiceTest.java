package com.booking.zoyorooms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;

import com.booking.zoyorooms.ZoyoRoomsApplication;
import com.booking.zoyorooms.entity.User;
import com.booking.zoyorooms.repository.UserRepository;
import com.booking.zoyorooms.service.UserService;
import com.booking.zoyorooms.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@SpringBootTest(classes = {ZoyoRoomsApplication.class})
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    // @BeforeAll
    // public static void setup(){
    //     userService = new UserServiceImpl();
    // }
    @Test
    public void saveUserTest(){
        // User user = new User(90, "Prateek",'M',"Indore");
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		// 	.buildAndExpand(user.getUserId()).toUri();
        // //when(userService.saveUser(user)).thenReturn(ResponseEntity.created(location).build());
        // verify(userService, times(1)).saveUser();
        // ResponseEntity<String> actualResponse = userService.saveUser(user);
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		// 	.buildAndExpand(user.getUserId()).toUri();
        // assertEquals(ResponseEntity.created(location).build(), actualResponse);
        
    }
    
}
