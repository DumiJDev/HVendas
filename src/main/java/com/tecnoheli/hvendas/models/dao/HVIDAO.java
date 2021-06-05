package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.util.jpa.JPAUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public interface HVIDAO<E> {

    default long conta() {
        return listarTodos().size();
    }

    default E inserir(E e) {
        var conexao = JPAUtil.abreConexao();
        var transicao = conexao.getTransaction();
        E e1 = null;
        try {
            transicao.begin();
            e1 = conexao.merge(e);
            transicao.commit();
        } catch (Exception ex) {
            transicao.rollback();
            ex.printStackTrace();
        } finally {
            conexao.close();
        }
        return e1;
    }

    default List<E> inserirTodos(List<E> e) {
        List<E> inseridos = new ArrayList<>();
        for (E e1 : e)
            inseridos.add(inserir(e1));

        return inseridos;
    }

    default E alterar(E e) {
        var conexao = JPAUtil.abreConexao();
        var transicao = conexao.getTransaction();
        E e1 = null;
        try {
            transicao.begin();
            e1 = conexao.merge(e);
            transicao.commit();
        } catch (Exception ex) {
            transicao.rollback();
            ex.printStackTrace();
        } finally {
            conexao.close();
        }
        return e1;
    }

    default List<E> alterarTodos(List<E> e) {
        List<E> inseridos = new ArrayList<>();
        for (E e1 : e)
            inseridos.add(alterar(e1));

        return inseridos;
    }

    default void excluir(Object id, Class<E> entidade) {
        var conexao = JPAUtil.abreConexao();
        var transicao = conexao.getTransaction();
        try {
            transicao.begin();
            if (existe(id, entidade))
                conexao.remove(conexao.find(entidade, id));
            transicao.commit();
        } catch (Exception ex) {
            transicao.rollback();
            ex.printStackTrace();
        } finally {
            conexao.close();
        }
    }

    void excluir(E e);

    default List<E> listarTodos(Class<E> entidade) {
        var conexao = JPAUtil.abreConexao();
        TypedQuery<E> query = conexao.createQuery("from " + entidade.getName(), entidade);
        final var result = query.getResultList();
        conexao.close();
        return result;
    }

    List<E> listarTodos();

    default E recuperar(Object id, Class<E> entidade) {
        final var conexao = JPAUtil.abreConexao();
        E e = conexao.find(entidade, id);
        conexao.close();
        return e;
    }

    E recuperar(Object id);

    default boolean existe(Object id, Class<E> entidade) {
        return recuperar(id, entidade) != null;
    }

    boolean existe(Object id);
}
