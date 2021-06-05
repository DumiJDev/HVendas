package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.BI;
import com.tecnoheli.hvendas.models.Funcao;
import com.tecnoheli.hvendas.models.Funcionario;


public final class FuncionarioBuilder {
    private Funcao funcao;
    private Double salario;
    private BI bi;

    private FuncionarioBuilder() {
    }

    public static FuncionarioBuilder novoFuncionario() {
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder comFuncao(Funcao funcao) {
        this.funcao = funcao;
        return this;
    }

    public FuncionarioBuilder comSalario(Double salario) {
        this.salario = salario;
        return this;
    }

    public FuncionarioBuilder comBi(BI bi) {
        this.bi = bi;
        return this;
    }

    public Funcionario build() {
        Funcionario funcionario = new Funcionario();
        funcionario.setFuncao(funcao);
        funcionario.setSalario(salario);
        funcionario.setBi(bi);
        return funcionario;
    }
}
