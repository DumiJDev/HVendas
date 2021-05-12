package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;

/**
 * Classe de relação entre a compra e o produto
 *
 * @author TecnoHeli
 */
public class ItemCompra implements Serializable {

    private long codigo;
    private long quantidade;

    private Compra compra;
    private Produto produto;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return getProduto().getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemCompra) {
            ItemCompra iC = (ItemCompra) o;
            if (iC.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
