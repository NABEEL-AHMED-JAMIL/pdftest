package com.ballistic.mongodbdemo.repository;

import com.ballistic.mongodbdemo.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, String>{
}
