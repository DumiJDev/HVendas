package com.tecnoheli.hvendas.dao;

import java.util.List;

public interface HVIDAO<T> {

    void inserir(T t);

    void alterar(T t);

    void excluir(T t);

    List<T> listarTodos();

    T recuperar(int codigo);
}
