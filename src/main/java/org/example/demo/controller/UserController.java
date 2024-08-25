package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.dto.SaveUserDto;
import org.example.demo.model.User;
import org.example.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "users/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public @ResponseBody SaveUserDto user(@Valid @RequestBody SaveUserDto user) {
        return userService.save(user);
    }

}
