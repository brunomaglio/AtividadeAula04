package com.aula04.servlet.session;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private static int contador = 1;
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
