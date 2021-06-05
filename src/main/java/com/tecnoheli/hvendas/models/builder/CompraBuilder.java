package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Compra;
import com.tecnoheli.hvendas.models.Fornecedor;
import com.tecnoheli.hvendas.models.Funcionario;
import com.tecnoheli.hvendas.models.Item;

import java.time.LocalDateTime;
import java.util.List;

public final class CompraBuilder {

    private LocalDateTime dataCompra;
    private List<Item> itens;
    private Fornecedor fornecedor;
    private Funcionario funcionario;

    private CompraBuilder() {
    }

    public static CompraBuilder novaCompra() {
        return new CompraBuilder();
    }

    public CompraBuilder comDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public CompraBuilder comItens(List<Item> itens) {
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
        compra.setDataCompra(dataCompra);
        compra.setItens(itens);
        compra.setFornecedor(fornecedor);
        compra.setFuncionario(funcionario);
        return compra;
    }
}
