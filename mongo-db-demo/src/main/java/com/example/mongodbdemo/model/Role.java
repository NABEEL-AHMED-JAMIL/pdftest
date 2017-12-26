package com.example.mongodbdemo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Nabeel on 12/24/2017.
 */
public class Role {

    @Id
    private String id;
    private String role;

    public Role() {}

    public Role(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
