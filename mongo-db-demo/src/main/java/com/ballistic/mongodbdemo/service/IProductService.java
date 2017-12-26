package com.ballistic.mongodbdemo.service;

import com.ballistic.mongodbdemo.commands.ProductForm;
import com.ballistic.mongodbdemo.domain.Product;

import java.util.List;

/**
 * Created by Nabeel on 12/12/2017.
 */
public interface IProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductFrom(ProductForm productForm);
}
