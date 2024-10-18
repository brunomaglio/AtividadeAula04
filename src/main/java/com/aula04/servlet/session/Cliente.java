package com.aula04.servlet.session;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private static int contador = 1;
    private String nome;
    private ArrayList<Produto> produtos;

    public Cliente(String nome) {
        this.id = contador++;
        this.nome = nome;
        this.produtos = new ArrayList<>();
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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
}
