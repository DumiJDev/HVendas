package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Estoque;

public final class EstoqueBuilder {
    private long quantidade;

    private EstoqueBuilder() {
    }

    public static EstoqueBuilder novoEstoque() {
        return new EstoqueBuilder();
    }

    public EstoqueBuilder comQuantidade(long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Estoque build() {
        Estoque estoque = new Estoque();
        estoque.setQuantidade(quantidade);
        return estoque;
    }
}
