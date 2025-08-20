package com.url.shortener.controllers;

import com.url.shortener.dto.LoginRequest;
import com.url.shortener.dto.RegisterRequest;
import com.url.shortener.models.User;
import com.url.shortener.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthContoller {

    private UserService userService;


    @PostMapping("public/login")

    public ResponseEntity<?> LoginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok (userService.authenticateUser(loginRequest));


    }











    @PostMapping("public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
       user.setEmail(registerRequest.getEmail());
        user.setRole("Role_USER");

        userService.registerUser(user);
        return ResponseEntity.ok("user Register successfully");

    }
}
