package com.gustavosantospro.softgu.controller;


import com.gustavosantospro.softgu.data.CreateProductDTO;
import com.gustavosantospro.softgu.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody @Validated CreateProductDTO data) {

        return ResponseEntity.ok(produtoService.create(data));
    }

}
