package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Produto;
import com.example.demo.view.shared.ProdutoDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produtoDto);
    List<ProdutoDto> obterProdutos();
    Optional<ProdutoDto> obterProduto(String id);
    void removerProduto(String id);
    ProdutoDto atualizarProduto(String id, ProdutoDto produto);
}
