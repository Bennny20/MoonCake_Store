/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.dto;

import java.io.Serializable;

/**
 *
 * @author phien
 */
public class UserDTO implements Serializable{
    private String userID;
    private String userName;
    private String password;
    private String address; 
    private String phone;
    private String email;
    private int roleID;

    public UserDTO(String userID, String userName, String password, String email, String address , String phone, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }   
}
