package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Cliente;
import com.tecnoheli.hvendas.models.Funcionario;
import com.tecnoheli.hvendas.models.Venda;

import java.time.LocalDateTime;

public final class VendaBuilder {
    private LocalDateTime dataVenda;
    private Cliente cliente;
    private Funcionario funcionario;

    private VendaBuilder() {
    }

    public static VendaBuilder novaVenda() {
        return new VendaBuilder();
    }

    public VendaBuilder comDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
        return this;
    }

    public VendaBuilder comCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public VendaBuilder comFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        return this;
    }

    public Venda build() {
        Venda venda = new Venda();
        venda.setDataVenda(dataVenda);
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        return venda;
    }
}
