package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Estoque;

public final class EstoqueBuilder {
    private long id;
    private long quantidade;

    private EstoqueBuilder() {
    }

    public static EstoqueBuilder anEstoque() {
        return new EstoqueBuilder();
    }

    public EstoqueBuilder comId(long id) {
        this.id = id;
        return this;
    }

    public EstoqueBuilder comQuantidade(long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Estoque build() {
        Estoque estoque = new Estoque();
        estoque.setId(id);
        estoque.setQuantidade(quantidade);
        return estoque;
    }
}
