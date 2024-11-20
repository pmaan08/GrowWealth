package com.wealth.growwealth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    private String password;  // hashed


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     public String getUsername() {
        return username;
     }
     public void setUsername(String username) {
        this.username = username;
     }
     public String getPassword() {
        return password;
     }
     public void setPassword(String password) {
        this.password = password;
     }
}
