package com.example.at_springboot.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    private String nome;
    private String senha;
    private String papel;

    public String getSenha() {
        return senha;
    }

    public void setId(String id) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPapel() {
        return papel;
    }

    public void setEmail(String papel) {
        this.papel = papel;
    }
}
