package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.User;
import com.wealth.growwealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody User loginRequestUser) {

        User user = userService.findByUsername(loginRequestUser.getUsername());

        //check if password matches
        if (user == null || !user.getPassword().equals(loginRequestUser.getPassword())) {
            // bad request
            User errorUser = new User();
            errorUser.setUsername("Invalid username or password");
            return ResponseEntity.badRequest().body(errorUser);
        }

        return ResponseEntity.ok(user);
    }
}
