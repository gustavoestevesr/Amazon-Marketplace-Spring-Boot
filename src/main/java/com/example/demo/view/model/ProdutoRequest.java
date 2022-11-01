package com.example.demo.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProdutoRequest {
    
    private int codigo;

    @NotBlank(message = "The name is blank")
    @NotEmpty(message = "The name is empty")
    @Size(min = 5, max = 40, message = "The min size is 5 and the max size is 40")
    private String nome;

    @NotBlank(message = "The price is blank")
    @Size(min = 0, message = "The min size is 0")
    private String valor;
    
    @NotBlank(message = "The quantity is blank")
    @Size(min = 0, message = "The quantity min size is 0")
    @NotEmpty(message = "The quantity is empty")
    private int quantidadeEstoque;
    
    public ProdutoRequest(int codigo,
            @NotBlank(message = "The name is blank") @NotEmpty(message = "The name is empty") @Size(min = 5, max = 40, message = "The min size is 5 and the max size is 40") String nome,
            @NotBlank(message = "The price is blank") @Size(min = 0, message = "The min size is 0") String valor,
            @NotBlank(message = "The quantity is blank") @Size(min = 0, message = "The quantity min size is 0") @NotEmpty(message = "The quantity is empty") int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    
}
