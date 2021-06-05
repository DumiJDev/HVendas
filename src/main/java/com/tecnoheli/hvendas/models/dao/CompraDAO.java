package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Compra;

import java.util.Iterator;
import java.util.List;

/**
 * Classe de acesso a dados da compra
 *
 * @author TecnoHeli
 */
public class CompraDAO implements HVIDAO<Compra> {
    @Override
    public void excluir(Compra compra) {
        excluir(compra.getCodigo(), Compra.class);
    }

    @Override
    public List<Compra> listarTodos() {
        return listarTodos(Compra.class);
    }

    @Override
    public Compra recuperar(Object id) {
        return recuperar(id, Compra.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Compra.class);
    }

    public Iterator<Compra> listarTodosComFuncionarioContendo(String chave) {
        return listarTodos().stream().filter(compra -> compra.getFuncionario().getBi().getNome().contains(chave)).iterator();
    }

    public Iterator<Compra> listarTodosComFornecedorContendo(String chave) {
        return listarTodos().stream().filter(compra -> compra.getFornecedor().getNome().contains(chave)).iterator();
    }
}
    
