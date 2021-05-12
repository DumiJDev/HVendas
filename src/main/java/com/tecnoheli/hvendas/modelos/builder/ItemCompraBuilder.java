package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Compra;
import com.tecnoheli.hvendas.modelos.ItemCompra;
import com.tecnoheli.hvendas.modelos.Produto;

public final class ItemCompraBuilder {
    private long codigo;
    private long quantidade;
    private Compra compra;
    private Produto produto;

    private ItemCompraBuilder() {
    }

    public static ItemCompraBuilder anItemCompra() {
        return new ItemCompraBuilder();
    }

    public ItemCompraBuilder comCodigo(long codigo) {
        this.codigo = codigo;
        return this;
    }

    public ItemCompraBuilder comQuantidade(long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemCompraBuilder comCompra(Compra compra) {
        this.compra = compra;
        return this;
    }

    public ItemCompraBuilder comProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public ItemCompra build() {
        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setCodigo(codigo);
        itemCompra.setQuantidade(quantidade);
        itemCompra.setCompra(compra);
        itemCompra.setProduto(produto);
        return itemCompra;
    }
}
