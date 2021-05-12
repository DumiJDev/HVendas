package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.*;

import java.util.List;

public final class FuncionarioBuilder {
    private long codigo;
    private Funcao funcao;
    private Double salario;
    private BI bi;
    private List<Venda> vendas;
    private List<Compra> compras;
    private Usuario usuario;

    private FuncionarioBuilder() {
    }

    public static FuncionarioBuilder aFuncionario() {
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder comCodigo(long codigo) {
        this.codigo = codigo;
        return this;
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

    public FuncionarioBuilder comVendas(List<Venda> vendas) {
        this.vendas = vendas;
        return this;
    }

    public FuncionarioBuilder comCompras(List<Compra> compras) {
        this.compras = compras;
        return this;
    }

    public FuncionarioBuilder comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Funcionario build() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(codigo);
        funcionario.setFuncao(funcao);
        funcionario.setSalario(salario);
        funcionario.setBi(bi);
        funcionario.setVendas(vendas);
        funcionario.setCompras(compras);
        funcionario.setUsuario(usuario);
        return funcionario;
    }
}
