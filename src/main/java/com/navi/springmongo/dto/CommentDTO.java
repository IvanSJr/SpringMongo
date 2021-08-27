package com.navi.springmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private String texto;
    private Date data;
    private AuthorDTO autor;

    public CommentDTO(){}

    public CommentDTO(String texto, Date data, AuthorDTO autor) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String id) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDTO getAutor() {
        return autor;
    }

    public void setAutor(AuthorDTO autor) {
        this.autor = autor;
    }
}
