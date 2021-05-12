package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Cliente;
import com.tecnoheli.hvendas.modelos.Venda;

import java.util.List;

public final class ClienteBuilder {
    private String id;
    private String nome;
    private String telefone;
    private List<Venda> compras;

    private ClienteBuilder() {
    }

    public static ClienteBuilder aCliente() {
        return new ClienteBuilder();
    }

    public ClienteBuilder comId(String id) {
        this.id = id;
        return this;
    }

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ClienteBuilder comCompras(List<Venda> compras) {
        this.compras = compras;
        return this;
    }

    public Cliente build() {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCompras(compras);
        return cliente;
    }
}
