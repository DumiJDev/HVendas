/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Venda;

import java.util.Iterator;
import java.util.List;

/**
 * @author TecnoHeli
 */
public class VendaDAO implements HVIDAO<Venda> {
    @Override
    public void excluir(Venda venda) {
        excluir(venda.getCodigo(), Venda.class);
    }

    @Override
    public List<Venda> listarTodos() {
        return listarTodos(Venda.class);
    }

    @Override
    public Venda recuperar(Object id) {
        return recuperar(id, Venda.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Venda.class);
    }

    public Iterator<Venda> listarTodosComClienteContendo(String chave) {
        return listarTodos().stream().filter(venda -> venda.getCliente().getNome().contains(chave)).iterator();
    }

    public Iterator<Venda> listarTodosComFuncionarioContendo(String chave) {
        return listarTodos().stream().filter(venda -> venda.getFuncionario().getBi().getNome().contains(chave)).iterator();

    }
}
