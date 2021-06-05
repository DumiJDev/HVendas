package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Funcionario;
import com.tecnoheli.hvendas.models.Tipo;
import com.tecnoheli.hvendas.models.Usuario;

public final class UsuarioBuilder {
    private Tipo tipo;
    private String login;
    private String senha;
    private Funcionario funcionario;

    private UsuarioBuilder() {
    }

    public static UsuarioBuilder novoUsuario() {
        return new UsuarioBuilder();
    }

    public UsuarioBuilder comTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public UsuarioBuilder comLogin(String login) {
        this.login = login;
        return this;
    }

    public UsuarioBuilder comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder comFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        return this;
    }

    public Usuario build() {
        Usuario usuario = new Usuario();
        usuario.setTipo(tipo);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setFuncionario(funcionario);
        return usuario;
    }
}
