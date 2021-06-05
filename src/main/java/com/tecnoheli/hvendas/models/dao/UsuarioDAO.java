package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Usuario;

import java.util.List;

public class UsuarioDAO implements HVIDAO<Usuario> {
    @Override
    public void excluir(Usuario usuario) {
        excluir(usuario.getLogin(), Usuario.class);
    }

    @Override
    public List<Usuario> listarTodos() {
        return listarTodos(Usuario.class);
    }

    @Override
    public Usuario recuperar(Object id) {
        return recuperar(id, Usuario.class);
    }

    public Usuario recuperar(String login, String senha) {
        if (existe(login))
            if (recuperar(login).getSenha().equals(senha))
                return recuperar(login);
        return null;
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Usuario.class);
    }


}
