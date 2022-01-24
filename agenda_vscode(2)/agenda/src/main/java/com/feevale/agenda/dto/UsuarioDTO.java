package com.feevale.agenda.dto;

import java.io.Serializable;

import com.feevale.agenda.models.Usuario;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String email;

    public UsuarioDTO() {
    }
    public UsuarioDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }
    public UsuarioDTO(Usuario user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
