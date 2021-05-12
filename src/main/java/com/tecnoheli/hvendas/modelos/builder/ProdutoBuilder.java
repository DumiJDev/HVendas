package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Estoque;
import com.tecnoheli.hvendas.modelos.Produto;

public final class ProdutoBuilder {
    private int codigo;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private Estoque estoque;

    private ProdutoBuilder() {
    }

    public static ProdutoBuilder aProduto() {
        return new ProdutoBuilder();
    }

    public ProdutoBuilder comCodigo(int codigo) {
        this.codigo = codigo;
        return this;
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
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setEstoque(estoque);
        return produto;
    }
}
