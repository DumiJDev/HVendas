package com.tecnoheli.hvendas.models.dao;


import com.tecnoheli.hvendas.models.Cliente;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de acesso a dados do cliente
 *
 * @author TecnoHeli
 */
public class ClienteDAO implements HVIDAO<Cliente> {

    @Override
    public void excluir(Cliente cliente) {
        excluir(cliente.getTelefone(), Cliente.class);
    }

    @Override
    public List<Cliente> listarTodos() {
        return listarTodos(Cliente.class);
    }

    @Override
    public Cliente recuperar(Object id) {
        return recuperar(id, Cliente.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Cliente.class);
    }

    public Iterator<Cliente> listarTodosComTelefoneContendo(String chave) {
        return listarTodos().stream().
                filter(cliente -> cliente.getTelefone().contains(chave)).
                sorted(Comparator.comparing(Cliente::getNome)).iterator();
    }

    public Iterator<Cliente> listarTodosComNomeContendo(String chave) {
        return listarTodos().stream().
                filter(cliente -> cliente.getNome().contains(chave)).
                sorted(Comparator.comparing(Cliente::getNome)).iterator();
    }
}
