package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Item;
import com.tecnoheli.hvendas.models.Produto;

public final class ItemBuilder {
    private long quantidade;
    private Produto produto;

    private ItemBuilder() {
    }

    public static ItemBuilder novoItem() {
        return new ItemBuilder();
    }

    public ItemBuilder comQuantidade(long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemBuilder comProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Item build() {
        Item item = new Item();
        item.setQuantidade(quantidade);
        item.setProduto(produto);
        return item;
    }
}
