package com.example.demo.view.shared;

public class ProdutoDto {
    
    private String id;
    private int codigo;
    private String nome;
    private String valor;
    private int quantidadeEstoque;
    
    public ProdutoDto(String id, int codigo, String nome, String valor, int quantidadeEstoque) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
}
