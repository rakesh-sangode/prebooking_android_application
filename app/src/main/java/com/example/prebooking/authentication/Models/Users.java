package com.example.prebooking.authentication.Models;

public class Users {
    public Users(String profile_pic, String Name, String email, String phone_no, String password, String userId) {
        this.profile_pic = profile_pic;
        this.Name = Name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
        this.userId = userId;

    }

    public Users () {}
    // Registration Constructor
    public Users(String Name, String email, String phone_no, String password) {
        this.Name = Name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    String profile_pic, Name, email, password, userId, phone_no;

}
