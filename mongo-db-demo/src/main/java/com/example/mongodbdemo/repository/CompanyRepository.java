package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
/**
 * Created by Nabeel on 12/24/2017.
 */
public interface CompanyRepository extends MongoRepository<Company, String>{
    List<Company> findByName(String name);
    @Query("{'contact.address': ?0}")
    List<Company> findByAddress(String address);
}
