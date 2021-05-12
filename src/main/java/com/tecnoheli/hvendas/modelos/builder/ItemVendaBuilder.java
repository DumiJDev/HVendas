package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.ItemVenda;
import com.tecnoheli.hvendas.modelos.Produto;
import com.tecnoheli.hvendas.modelos.Venda;

public final class ItemVendaBuilder {
    private long codigo;
    private long quantidade;
    private Venda venda;
    private Produto produto;

    private ItemVendaBuilder() {
    }

    public static ItemVendaBuilder anItemVenda() {
        return new ItemVendaBuilder();
    }

    public ItemVendaBuilder comCodigo(long codigo) {
        this.codigo = codigo;
        return this;
    }

    public ItemVendaBuilder comQuantidade(long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemVendaBuilder comVenda(Venda venda) {
        this.venda = venda;
        return this;
    }

    public ItemVendaBuilder comProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public ItemVenda build() {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setCodigo(codigo);
        itemVenda.setQuantidade(quantidade);
        itemVenda.setVenda(venda);
        itemVenda.setProduto(produto);
        return itemVenda;
    }
}
