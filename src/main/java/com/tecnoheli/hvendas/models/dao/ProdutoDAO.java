package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Produto;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de acesso a dados do produto
 *
 * @author TecnoHeli
 */
public class ProdutoDAO implements HVIDAO<Produto> {
    @Override
    public void excluir(Produto produto) {
        excluir(produto.getCodigo(), Produto.class);
    }

    @Override
    public List<Produto> listarTodos() {
        final var lista = listarTodos(Produto.class);
        lista.sort(Comparator.comparing(Produto::getNome));
        return lista;
    }

    @Override
    public Produto recuperar(Object id) {
        return recuperar(id, Produto.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Produto.class);
    }

    public Iterator<Produto> listarTodosComNomeContendo(String chave) {
        return listarTodos().stream().filter(produto -> produto.getNome().contains(chave)).iterator();
    }

    public Iterator<Produto> listarTodosComPrecoAte(Double chave) {
        return listarTodos().stream().
                filter(produto -> produto.getPrecoVenda() <= chave).
                sorted(Comparator.comparing(Produto::getPrecoVenda)).
                iterator();
    }
}
