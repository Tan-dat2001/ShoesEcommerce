package com.shoesecom.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Register {
    private int account_id;
    private String email;
    private String password;
    private String name;
    private String role;
    private String status;
    private String gender;
    private String address;
    private String phone;
    private Date dateofbirth;
    private int code;

    public Register(int account_id, String email, String password, String name, String role, String status, String gender, String address, String phone, Date dateofbirth, int code) {
        this.account_id = account_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.status = status;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.dateofbirth = dateofbirth;
        this.code = code;
    }


    public Register() {
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
