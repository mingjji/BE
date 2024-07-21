package com.likelion.MoodMate.controller;

import com.likelion.MoodMate.entity.User;
import com.likelion.MoodMate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Boolean>> loginUser(@RequestBody Map<String, String> loginData) {
        String userId = loginData.get("userId");
        String userPw = loginData.get("userPw");
        boolean isMember = userService.validateUser(userId, userPw);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isMember", isMember);
        return ResponseEntity.ok(response);
    }
}
