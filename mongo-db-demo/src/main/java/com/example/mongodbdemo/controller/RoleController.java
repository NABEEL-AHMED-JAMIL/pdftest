package com.example.mongodbdemo.controller;

import com.example.mongodbdemo.model.Role;
import com.example.mongodbdemo.repository.RoleRepository;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // create
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Role create(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // read
    @RequestMapping(value = "/{id}")
    public Role read(@PathVariable String id) {
        return roleRepository.findOne(id);
    }

    // update
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Role update(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        roleRepository.delete(id);
    }

    @RequestMapping(value = "/Roles", method = RequestMethod.GET)
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
