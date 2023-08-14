/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edii.jobtest.repository;

import com.edii.jobtest.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("SELECT a FROM User a WHERE a.namalengkap = ?1")
    Optional<User> findUserByNamaLengkap (String namaLengkap);
}
