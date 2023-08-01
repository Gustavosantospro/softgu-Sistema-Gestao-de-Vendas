package com.gustavosantospro.softgu.service;


import com.gustavosantospro.softgu.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void createProduct(Product product);
}
