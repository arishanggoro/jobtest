/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edii.jobtest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_user")
public class User {
    
    @Id
    private Integer userid;
    private String namalengkap;
    private String username;
    private String password;
    private String status;

    public User() {
    }

    public User(Integer userid, String namalengkap, String username, String password, String status) {
        this.userid = userid;
        this.namalengkap = namalengkap;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", namalengkap=" + namalengkap + ", username=" + username + ", password=" + password + ", status=" + status + '}';
    }

    
}
