package com.tecnoheli.hvendas.modelos.builder;

import com.tecnoheli.hvendas.modelos.Compra;
import com.tecnoheli.hvendas.modelos.Fornecedor;
import com.tecnoheli.hvendas.modelos.Produto;

import java.util.List;

public final class FornecedorBuilder {
    private int codigo;
    private String nome;
    private String nif;
    private List<Produto> produtos;
    private List<Compra> compras;

    private FornecedorBuilder() {
    }

    public static FornecedorBuilder aFornecedor() {
        return new FornecedorBuilder();
    }

    public FornecedorBuilder comCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public FornecedorBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FornecedorBuilder comNif(String nif) {
        this.nif = nif;
        return this;
    }

    public FornecedorBuilder comProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public FornecedorBuilder comCompras(List<Compra> compras) {
        this.compras = compras;
        return this;
    }

    public Fornecedor build() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCodigo(codigo);
        fornecedor.setNome(nome);
        fornecedor.setNif(nif);
        fornecedor.setProdutos(produtos);
        fornecedor.setCompras(compras);
        return fornecedor;
    }
}
