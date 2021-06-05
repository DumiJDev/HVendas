package com.tecnoheli.hvendas.models.dao;

//import vender.IDAO;

import com.tecnoheli.hvendas.models.Fornecedor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de acesso a dados do fornecedor
 *
 * @author TecnoHeli
 */
public class FornecedorDAO implements HVIDAO<Fornecedor> {
    @Override
    public void excluir(Fornecedor fornecedor) {
        excluir(fornecedor.getNif(), Fornecedor.class);
    }

    @Override
    public List<Fornecedor> listarTodos() {
        return listarTodos(Fornecedor.class);
    }

    @Override
    public Fornecedor recuperar(Object id) {
        return recuperar(id, Fornecedor.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Fornecedor.class);
    }

    public Iterator<Fornecedor> listarTodosComNIFContendo(String chave) {
        return listarTodos().stream().
                filter(fornecedor -> fornecedor.getNif().contains(chave)).
                sorted(Comparator.comparing(Fornecedor::getNif)).iterator();
    }

    public Iterator<Fornecedor> listarTodosComNomeContendo(String chave) {
        return listarTodos().stream().
                filter(fornecedor -> fornecedor.getNome().contains(chave)).
                sorted(Comparator.comparing(Fornecedor::getNome)).iterator();
    }

    public Iterator<Fornecedor> listarTodosComProdutoContendo(String chave) {
        final var resultado = new ArrayList<Fornecedor>();
        for (Fornecedor f : listarTodos())
            if (f.getProdutos().stream().anyMatch(produto -> produto.getNome().contains(chave)))
                resultado.add(f);

        return resultado.iterator();
    }
}
