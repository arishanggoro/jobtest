/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edii.jobtest.service;

import com.edii.jobtest.model.User;
import com.edii.jobtest.repository.UserRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getDataUser(){
        return userRepository.findAll();
    }
    
    public User getDataUserById(Integer id){
        User obj = userRepository.findById(id).orElseThrow(()-> new IllegalStateException("Maaf, User Id tidak ditemukan."));
        User user = new User();
        user.setUserid(obj.getUserid());
        user.setNamalengkap(obj.getNamalengkap());
        user.setUsername(obj.getUsername());
        user.setPassword(obj.getPassword());
        user.setStatus(obj.getStatus());
        return user;
    }
    
    public ResponseEntity<?> setDataUser(User user){
        Map<String, Object> map = new LinkedHashMap<String, Object>(); //for return message
        
        Optional<User> checkUserId = userRepository.findById(user.getUserid());
        if(checkUserId.isPresent()){
            throw new IllegalStateException("Maaf, User Id sudah terdaftar.");
        } else {
            userRepository.save(user);
            
            //for return message
            map.put("status", 1);
            map.put("message", "User berhasil ditambahkan");
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        }
        
    }
    
    public ResponseEntity<?> delDataUser(Integer id){
        Map<String, Object> map = new LinkedHashMap<String, Object>(); //for return message
        
        boolean found = userRepository.existsById(id);
        if(!found){
            throw new IllegalStateException("Maaf, User Id tidak ditemukan.");
        } else {
            userRepository.deleteById(id);
            
            //for return message
            map.put("status", 1);
            map.put("message", "User berhasil dihapus");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
