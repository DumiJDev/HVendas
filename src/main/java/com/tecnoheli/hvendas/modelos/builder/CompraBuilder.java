package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Compra;
import com.tecnoheli.hvendas.modelos.Fornecedor;
import com.tecnoheli.hvendas.modelos.Funcionario;
import com.tecnoheli.hvendas.modelos.ItemCompra;

import java.time.LocalDate;
import java.util.List;

public final class CompraBuilder {
    private long codigo;
    private LocalDate dataCompra;
    private List<ItemCompra> itens;
    private Fornecedor fornecedor;
    private Funcionario funcionario;

    private CompraBuilder() {
    }

    public static CompraBuilder aCompra() {
        return new CompraBuilder();
    }

    public CompraBuilder comCodigo(long codigo) {
        this.codigo = codigo;
        return this;
    }

    public CompraBuilder comDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public CompraBuilder comItens(List<ItemCompra> itens) {
        this.itens = itens;
        return this;
    }

    public CompraBuilder comFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        return this;
    }

    public CompraBuilder comFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        return this;
    }

    public Compra build() {
        Compra compra = new Compra();
        compra.setCodigo(codigo);
        compra.setDataCompra(dataCompra);
        compra.setItens(itens);
        compra.setFornecedor(fornecedor);
        compra.setFuncionario(funcionario);
        return compra;
    }
}
