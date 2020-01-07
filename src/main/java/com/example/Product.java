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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the data_de_lancamento
     */
    public String getDatadelancamento() {
        return this.data_de_lancamento;
    }

    /**
     * @param data_de_lancamento the data_de_lancamento to set
     */
    public void setDatadelancamento(String data_de_lancamento) {
        this.data_de_lancamento = data_de_lancamento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}