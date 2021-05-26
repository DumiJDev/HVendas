package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;

/**
 * Classe contendo os dados do produto
 *
 * @author TecnoHeli
 */
public class Produto implements Serializable {

    private int codigo;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;

    private Estoque estoque;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto)
            return ((Produto) o).getCodigo() == this.getCodigo();
        return false;
    }
}
