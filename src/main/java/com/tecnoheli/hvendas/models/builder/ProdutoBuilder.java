package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Estoque;
import com.tecnoheli.hvendas.models.Produto;

public final class ProdutoBuilder {
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private Estoque estoque;

    private ProdutoBuilder() {
    }

    public static ProdutoBuilder novoProduto() {
        return new ProdutoBuilder();
    }

    public ProdutoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder comPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
        return this;
    }

    public ProdutoBuilder comPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
        return this;
    }

    public ProdutoBuilder comEstoque(Estoque estoque) {
        this.estoque = estoque;
        return this;
    }

    public Produto build() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setEstoque(estoque);
        return produto;
    }
}
