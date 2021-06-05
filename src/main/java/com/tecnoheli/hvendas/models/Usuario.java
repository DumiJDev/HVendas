/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author TecnoHeli
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Id
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne
    private Funcionario funcionario;

    public Usuario() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getLogin().equals(usuario.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin());
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
