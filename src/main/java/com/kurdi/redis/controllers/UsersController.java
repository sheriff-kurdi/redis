package com.kurdi.redis.controllers;

import com.kurdi.redis.models.User;
import com.kurdi.redis.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/save")
    public ResponseEntity<String> save()
    {
        User user = User.builder().name("kurdi").email("kurdi@mail").age(22).build();
        boolean result = usersService.save(user);
        if (result)
            return ResponseEntity.ok("User Created!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/save")
    public ResponseEntity<List<User>> get(){
        List<User> users = usersService.getAll();
        return ResponseEntity.ok(users);
    }
}
