package com.example.demo.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import com.example.demo.view.model.ProdutoRequest;
import com.example.demo.view.model.ProdutoResponse;
import com.example.demo.view.shared.ProdutoDto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> obterTodosProdutos(){
        List<ProdutoDto> produtosDTO = servico.obterProdutos();

        List<ProdutoDto> produtos = produtosDTO.stream()
        .map( p -> new ModelMapper().map( p , ProdutoDto.class))
        .collect( Collectors.toList() );

        return new ResponseEntity<>(produtos, HttpStatus.FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ProdutoDto> obterProduto(@PathVariable String id){
        Optional<ProdutoDto> produto = servico.obterProduto(id);

        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);     
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid ProdutoRequest produto){        
        ModelMapper mapper = new ModelMapper();
        ProdutoDto produtoDto = mapper.map(produto, ProdutoDto.class);
        produtoDto = servico.criarProduto(produtoDto);
        return new ResponseEntity<>(mapper.map(produtoDto, null), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id){
        servico.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable String id, @RequestBody ProdutoDto novoProduto){
        Optional<ProdutoDto> produto = servico.obterProduto(id);

        if (produto.isPresent()) {
            return new ResponseEntity<>(servico.atualizarProduto(id, novoProduto), HttpStatus.ACCEPTED); 
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
