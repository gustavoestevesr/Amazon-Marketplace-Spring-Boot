package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Produto;

public interface ProdutoService {
    Produto criarProduto(Produto produto);
    List<Produto> obterProdutos();
    Produto obterProduto(String id);
    void removerProduto(String id);
    Produto atualizarProduto(String id, Produto produto);
}
