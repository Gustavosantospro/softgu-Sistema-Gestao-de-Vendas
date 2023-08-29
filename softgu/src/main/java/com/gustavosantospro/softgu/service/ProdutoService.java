package com.gustavosantospro.softgu.service;

import com.gustavosantospro.softgu.data.CreateProductDTO;
import com.gustavosantospro.softgu.model.Produto;
import com.gustavosantospro.softgu.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public ResponseEntity create(CreateProductDTO data) {
        Produto product = new Produto(data.name(), data.description(), data.price());
        produtoRepository.save(product);
        return ResponseEntity.ok().body("create succefully");
    }
}
