package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public Produto criarProduto(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public List<Produto> obterProdutos() {
        return repositorio.findAll();
    }

    @Override
    public Produto obterProduto(String id) {
        return repositorio.findById(id).get();
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Produto atualizarProduto(String id, Produto produto){
        produto.setId(id);
        return repositorio.save(produto);
    }
    
}
