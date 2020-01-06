package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;
    private Long senha;
    protected User() {}
    public User(String nome, String sobrenome, Long senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
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
     * @return the Sobrenome
     */
    public String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the senha
     */
    public Long getSenha() {
        return this.senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(Long senha) {
        this.senha = senha;
    }
}