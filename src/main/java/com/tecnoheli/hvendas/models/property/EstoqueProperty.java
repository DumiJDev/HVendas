package com.tecnoheli.hvendas.models.property;

import com.tecnoheli.hvendas.models.Estoque;
import com.tecnoheli.hvendas.models.builder.EstoqueBuilder;
import javafx.beans.property.SimpleLongProperty;

public class EstoqueProperty {

    private final SimpleLongProperty quantidade;


    public EstoqueProperty(long quantidade) {
        this.quantidade = new SimpleLongProperty(quantidade);
    }

    public long getQuantidade() {
        return quantidade.get();
    }

    public SimpleLongProperty quantidadeProperty() {
        return quantidade;
    }

    public Estoque get() {
        return EstoqueBuilder.novoEstoque().comQuantidade(getQuantidade()).build();
    }
}
