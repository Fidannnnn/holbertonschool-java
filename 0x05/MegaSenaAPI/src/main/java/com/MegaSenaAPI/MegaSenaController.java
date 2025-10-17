package com.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String welcomeMessage() {
        return "Welcome to the REST API for generating numbers for the Mega Sena lottery.";
    }

    @GetMapping("/getNumbers")
    public List<Integer> megaSenaNumbers() {
        // Generate 6 unique numbers in [1, 60] and return in *descending* order
        Set<Integer> unique = new HashSet<>();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        while (unique.size() < 6) {
            unique.add(rnd.nextInt(1, 61)); // 1..60 inclusive
        }

        List<Integer> numbers = new ArrayList<>(unique);
        // Sort descending as per objective
        numbers.sort(Collections.reverseOrder());
        return numbers;
    }
}
