package com.maiyatrack.controller;

import com.maiyatrack.dto.UserDTO;
import com.maiyatrack.entity.User;
import com.maiyatrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO registerDTO) {
        User user = userService.registerUser(registerDTO);
        return ResponseEntity.ok(user);
    }
    
    // @PostMapping("/login")
    // public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
    //     User user = userService.login(email, password);
    //     return ResponseEntity.ok(user);
    // }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDTO loginDTO) {
        User user = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok(user);
    }

} 