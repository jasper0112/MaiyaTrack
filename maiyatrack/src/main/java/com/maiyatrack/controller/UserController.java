package com.maiyatrack.controller;

import com.maiyatrack.dto.AuthResponse;
import com.maiyatrack.dto.UserDTO;
import com.maiyatrack.entity.User;
import com.maiyatrack.security.JwtUtil;
import com.maiyatrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDTO registerDTO) {
        User user = userService.registerUser(registerDTO);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        
        AuthResponse response = new AuthResponse(jwt, user.getEmail(), user.getUsername());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDTO loginDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        
        User user = userService.getUserByEmail(loginDTO.getEmail());
        AuthResponse response = new AuthResponse(jwt, user.getEmail(), user.getUsername());
        return ResponseEntity.ok(response);
    }
} 