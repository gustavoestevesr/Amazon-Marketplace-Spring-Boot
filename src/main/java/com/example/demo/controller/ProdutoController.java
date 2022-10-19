package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService servico;

    @GetMapping
    public List<Produto> obterTodosProdutos(){
        return servico.obterProdutos();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable String id){
        return new ResponseEntity<>(servico.obterProduto(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        return new ResponseEntity<>(servico.criarProduto(produto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id){
        servico.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String id, @RequestBody Produto produto){
        return new ResponseEntity<>(servico.atualizarProduto(id, produto), HttpStatus.OK);
    }

}
