package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Nabeel on 12/24/2017.
 */
public interface UserRepository extends MongoRepository<User, String>{

    public User findOneByName(String name);
}
