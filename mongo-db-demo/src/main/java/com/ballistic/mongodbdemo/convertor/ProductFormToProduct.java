package com.ballistic.mongodbdemo.convertor;

import com.ballistic.mongodbdemo.commands.ProductForm;
import com.ballistic.mongodbdemo.domain.Product;
import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        if(productForm.getId() != null && !StringUtils.isEmpty(productForm.getId())) {
            product.setId(new ObjectId(productForm.getId()));
        }
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());

        return product;
    }
}
