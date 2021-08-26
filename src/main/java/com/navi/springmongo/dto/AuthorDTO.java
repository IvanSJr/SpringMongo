package com.navi.springmongo.dto;

import com.navi.springmongo.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String nome;

    public AuthorDTO(){

    }

    public AuthorDTO(User user){
        this.id = user.getId();
        this.nome = user.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
