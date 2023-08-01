package com.gustavosantospro.softgu.controller;

import com.gustavosantospro.softgu.model.Product;
import com.gustavosantospro.softgu.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/product")
@Data
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("/criarProduto")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

}
