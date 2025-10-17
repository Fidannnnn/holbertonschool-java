package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) {
            return "You have entered a valid ID";
        }
        // Throw custom exception for invalid data
        throw new UserIdException(String.valueOf(id));
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (userName != null && userName.length() > 3 && userName.length() < 15) {
            return "You have entered a valid USERNAME";
        }
        throw new UserNameException(userName);
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        boolean isCPFValid = isCPF(cpf);
        if (isCPFValid) {
            return "You have entered a valid CPF";
        }
        throw new CPFException(cpf);
    }

    // Per assignment: simple validation based on length (no real CPF algorithm here)
    public boolean isCPF(String CPF) {
        return CPF != null && CPF.length() > 3 && CPF.length() < 15;
    }
}
