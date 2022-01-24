package com.feevale.agenda.dto;

import java.io.Serializable;

public class ContatoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String apelido;
    private String telefone;
    private boolean ehFamiliar;

    public ContatoDTO(Integer id, String nome, String apelido, String telefone, boolean ehFamiliar) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.ehFamiliar = ehFamiliar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isEhFamiliar() {
        return ehFamiliar;
    }

    public void setEhFamiliar(boolean ehFamiliar) {
        this.ehFamiliar = ehFamiliar;
    }

}
