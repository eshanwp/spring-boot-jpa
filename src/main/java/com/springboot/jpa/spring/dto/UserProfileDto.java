package com.springboot.jpa.spring.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserProfileDto implements Serializable {

    private int id;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String gender;
    private String mobileNo;
    private Timestamp dob;
    private int userId;

    private UserDto userDto;

    public UserProfileDto(int id, String address1, String address2, String city, String country, String gender, String mobileNo, Timestamp dob, int userId, UserDto userDto) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.userId = userId;
        this.userDto = userDto;
    }

    public UserProfileDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "UserProfileDto{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dob=" + dob +
                ", userId=" + userId +
                ", userDto=" + userDto +
                '}';
    }
}
