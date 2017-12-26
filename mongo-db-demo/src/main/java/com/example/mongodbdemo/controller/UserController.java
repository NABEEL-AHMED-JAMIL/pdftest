package com.example.mongodbdemo.controller;

import com.example.mongodbdemo.model.User;
import com.example.mongodbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/**
 * Created by Nabeel on 12/24/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // create
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    // read
    @RequestMapping(value = "/{id}")
    public User read(@PathVariable String id) {
        return userRepository.findOne(id);
    }

    // update
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    // delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        userRepository.delete(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
