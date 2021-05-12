package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Cliente;
import com.tecnoheli.hvendas.modelos.Funcionario;
import com.tecnoheli.hvendas.modelos.Venda;

import java.time.LocalDate;

public final class VendaBuilder {
    private int codigo;
    private LocalDate dataVenda;
    private Cliente cliente;
    private Funcionario funcionario;

    private VendaBuilder() {
    }

    public static VendaBuilder aVenda() {
        return new VendaBuilder();
    }

    public VendaBuilder comCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public VendaBuilder comDataVenda(LocalDate dataVenda) {
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
        venda.setCodigo(codigo);
        venda.setDataVenda(dataVenda);
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        return venda;
    }
}
