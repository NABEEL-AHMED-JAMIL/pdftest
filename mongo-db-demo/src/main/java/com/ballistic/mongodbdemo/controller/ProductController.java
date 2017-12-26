package com.ballistic.mongodbdemo.controller;

import com.ballistic.mongodbdemo.commands.ProductForm;
import com.ballistic.mongodbdemo.convertor.ProductToProductFrom;
import com.ballistic.mongodbdemo.domain.Product;
import com.ballistic.mongodbdemo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Nabeel on 12/12/2017.
 */
@Controller
public class ProductController {

    private IProductService iProductService;
    private ProductToProductFrom productToProductFrom;

    @Autowired
    public IProductService getiProductService() { return iProductService; }
    @Autowired
    public ProductToProductFrom getProductToProductFrom() { return productToProductFrom; }

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/product/list";
    }

    @RequestMapping({ "/product/list", "/product" })
    public String listProducts(Model model){
        model.addAttribute("products", iProductService.listAll());
        return "/product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", iProductService.getById(id));
        return "product/show";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Product product = iProductService.getById(id);
        ProductForm productForm = productToProductFrom.convert(product);
        model.addAttribute("productForm", productForm);

        return "/product/productForm";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new ProductForm());

        return "/product/productForm";
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Product savedProduct = iProductService.saveOrUpdateProductFrom(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        iProductService.delete(id);
        return "redirect:/product/list";
    }
}
