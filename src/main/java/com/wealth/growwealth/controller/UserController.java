package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.User;
import com.wealth.growwealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    // login endPoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequestUser) {

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

    // signUp endPoint
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User signupRequest) {

        if (userService.findByUsername(signupRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Save the user
        userService.saveUser(signupRequest);

        return ResponseEntity.ok("User created successfully");
    }


}
