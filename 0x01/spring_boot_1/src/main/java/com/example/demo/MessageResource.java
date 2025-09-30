package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "WELCOME TO THE MICRO-SERVICE CLASS USING SPRING BOOT!!!";
    }

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "user", required = false) String user,
            @RequestParam(value = "password", required = false) String password) {

        // Treat null or blank as "not provided"
        boolean userMissing = (user == null || user.trim().isEmpty());
        boolean pwdMissing  = (password == null || password.trim().isEmpty());
        if (userMissing || pwdMissing) {
            return "USER AND PASSWORD NOT PROVIDED";
        }

        // Length > 15 => invalid
        if (user.length() > 15 || password.length() > 15) {
            return "USER AND PASSWORD INVALID";
        }

        // Otherwise, success
        return "LOGIN SUCCESSFUL!!!";
    }
}
