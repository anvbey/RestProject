package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServices.getUserList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id)
    {
        return ResponseEntity.ok().body(this.userServices.getUserById(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(this.userServices.createUser(user));
    }

    @PutMapping("/updateUsers/")
    public ResponseEntity<User> updateUsers(@RequestBody User user){
        return ResponseEntity.ok().body(this.userServices.updateUserById(user));
    }

    @DeleteMapping("/deleteUsers/{id}")
    public HttpStatus deleteUser(@PathVariable int id){
        this.userServices.deleteUserById(id);
        return HttpStatus.OK;
    }
}
