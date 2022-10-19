package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    
}
