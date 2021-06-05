package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Cliente;

public final class ClienteBuilder {
    private String nome;
    private String telefone;

    private ClienteBuilder() {
    }

    public static ClienteBuilder novoCliente() {
        return new ClienteBuilder();
    }

    public ClienteBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public Cliente build() {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        return cliente;
    }
}
