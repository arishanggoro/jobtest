/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edii.jobtest.rest;

import com.edii.jobtest.model.User;
import com.edii.jobtest.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path="api/user")
public class UserRest {
    
    private final UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/getDataUser")
    public List<User> getDataUser(){
        return userService.getDataUser();
    }
    
    @GetMapping("/getDataUser/{userid}")
    public User getDataUserById(@PathVariable("userid") Integer id){
        return userService.getDataUserById(id);
    }
    
    @PostMapping("/setDataUser")
    public ResponseEntity<?> setDataUser(@RequestBody User user){
        return userService.setDataUser(user);
    }
    
    @DeleteMapping("/delDataUser/{userid}")
    public ResponseEntity<?> delDataUser(@PathVariable("userid") Integer id){
        return userService.delDataUser(id);
    }
    
    
}
