package com.ballistic.mongodbdemo.repository;

import com.ballistic.mongodbdemo.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {

    Hotel findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);

}
