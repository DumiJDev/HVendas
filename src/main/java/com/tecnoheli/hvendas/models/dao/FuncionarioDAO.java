package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Funcionario;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FuncionarioDAO implements HVIDAO<Funcionario> {
    @Override
    public void excluir(Funcionario funcionario) {
        excluir(funcionario.getCodigo(), Funcionario.class);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return listarTodos(Funcionario.class);
    }

    @Override
    public Funcionario recuperar(Object id) {
        return recuperar(id, Funcionario.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Funcionario.class);
    }

    public Iterator<Funcionario> listarTodosComNomeContendo(String chave) {
        return listarTodos().stream().
                filter(funcionario -> funcionario.getBi().getNome().contains(chave)).
                sorted(Comparator.comparing(o -> o.getBi().getNome())).iterator();
    }

    public Iterator<Funcionario> listarTodosComFuncaoContendo(String chave) {
        return listarTodos().stream().
                filter(funcionario -> funcionario.getFuncao().name().contains(chave)).
                sorted(Comparator.comparing(Funcionario::getFuncao)).iterator();
    }
}
