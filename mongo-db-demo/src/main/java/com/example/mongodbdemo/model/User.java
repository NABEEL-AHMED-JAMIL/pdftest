package com.example.mongodbdemo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Nabeel on 12/24/2017.
 */
public class User {

    @Id
    private String id;
    private String name;
    private String age;
    private String email;
    private Role role;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
