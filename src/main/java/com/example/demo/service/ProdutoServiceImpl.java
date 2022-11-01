package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.view.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repositorio.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterProdutos() {
        List<Produto> produtos = repositorio.findAll();

        return produtos.stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterProduto(String id) {
        Optional<Produto> produto = repositorio.findById(id);

        if (produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produto) {
        Produto novoProduto = new ModelMapper().map(produto, Produto.class);
        novoProduto.setId(id);
        novoProduto = repositorio.save(novoProduto);
        return new ModelMapper().map(novoProduto, ProdutoDto.class);
    }

}
