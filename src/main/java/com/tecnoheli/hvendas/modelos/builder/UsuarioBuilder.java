package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Funcionario;
import com.tecnoheli.hvendas.modelos.Tipo;
import com.tecnoheli.hvendas.modelos.Usuario;

public final class UsuarioBuilder {
    private String nome_de_usuario;
    private Tipo tipo;
    private String login;
    private String senha;
    private Funcionario funcionario;

    private UsuarioBuilder() {
    }

    public static UsuarioBuilder anUsuario() {
        return new UsuarioBuilder();
    }

    public UsuarioBuilder comNome_de_usuario(String nome_de_usuario) {
        this.nome_de_usuario = nome_de_usuario;
        return this;
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
        usuario.setNome_de_usuario(nome_de_usuario);
        usuario.setTipo(tipo);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setFuncionario(funcionario);
        return usuario;
    }
}
