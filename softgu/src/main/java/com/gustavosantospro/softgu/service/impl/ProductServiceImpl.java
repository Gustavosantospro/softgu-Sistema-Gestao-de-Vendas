package com.gustavosantospro.softgu.service.impl;

import com.gustavosantospro.softgu.model.Product;
import com.gustavosantospro.softgu.repository.ProductRepository;
import com.gustavosantospro.softgu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
