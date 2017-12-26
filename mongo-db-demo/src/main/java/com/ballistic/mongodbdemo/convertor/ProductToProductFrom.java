package com.ballistic.mongodbdemo.convertor;

import com.ballistic.mongodbdemo.commands.ProductForm;
import com.ballistic.mongodbdemo.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Component
public class ProductToProductFrom implements Converter<Product, ProductForm> {
    
	@Override
    public ProductForm convert(Product product) {

        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId().toHexString());
        productForm.setPrice(product.getPrice());
        productForm.setDescription(product.getDescription());
        productForm.setImageUrl(product.getImageUrl());

        return productForm;
    }
}
