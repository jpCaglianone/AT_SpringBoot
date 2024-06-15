package com.example.at_springboot.model.dto;

import java.util.List;

public class DepartamentoDTO {

    private long id;
    private String nome;
    private String local;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
