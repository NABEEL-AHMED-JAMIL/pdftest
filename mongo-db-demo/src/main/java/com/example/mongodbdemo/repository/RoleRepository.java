package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Nabeel on 12/24/2017.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
}
