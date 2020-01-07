package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private String data_de_lancamento;
    private double valor;
    private int quantidade;
    protected Product() {}
    public Product(String nome, String genero, String data_de_lancamento, double valor, int quantidade) {
        this.nome = nome;
        this.genero = genero;
        this.data_de_lancamento = data_de_lancamento;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDatadelancamento() {
        return this.data_de_lancamento;
    }

    public void setDatadelancamento(String data_de_lancamento) {
        this.data_de_lancamento = data_de_lancamento;
    }

    public double getValor() {
        return this.valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}