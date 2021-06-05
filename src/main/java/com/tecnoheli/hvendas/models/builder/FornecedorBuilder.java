package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.Fornecedor;
import com.tecnoheli.hvendas.models.Produto;

import java.util.List;

public final class FornecedorBuilder {

    private String nome;
    private String nif;
    private List<Produto> produtos;

    private FornecedorBuilder() {
    }

    public static FornecedorBuilder novoFornecedor() {
        return new FornecedorBuilder();
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

    public Fornecedor build() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setNif(nif);
        fornecedor.setProdutos(produtos);
        return fornecedor;
    }
}
