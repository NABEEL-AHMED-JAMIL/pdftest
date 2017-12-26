package com.ballistic.mongodbdemo.service;

import com.ballistic.mongodbdemo.commands.ProductForm;
import com.ballistic.mongodbdemo.convertor.ProductFormToProduct;
import com.ballistic.mongodbdemo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ballistic.mongodbdemo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Service
public class ProductServiceImpl implements IProductService{

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;
    private List<Product> products;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductFormToProduct productFormToProduct) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<Product> listAll() {
        products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(String id) { return productRepository.findOne(id); }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(String id) { productRepository.delete(id); }

    @Override
    public Product saveOrUpdateProductFrom(ProductForm productForm) {
        Product saveProduct = saveOrUpdate(productFormToProduct.convert(productForm));
        return saveProduct;
    }
}
