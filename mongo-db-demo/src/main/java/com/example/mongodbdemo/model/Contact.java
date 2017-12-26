package com.example.mongodbdemo.model;

/**
 * Created by Nabeel on 12/24/2017.
 */
public class Contact {

    private String address;
    private String phone;

    public Contact() {
    }

    public Contact(String address, String phone) {
        this.address = address;
        this.phone = phone;
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
}
