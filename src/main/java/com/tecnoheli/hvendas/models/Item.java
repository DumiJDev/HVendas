package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe de relação entre a compra/Venda e o produto
 *
 * @author TecnoHeli
 */
@Entity
@Table(name = "Items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "qtd")
    private Long quantidade;
    @OneToOne
    private Produto produto;

    public Item() {
    }

    public long getCodigo() {
        return codigo;
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
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return codigo.equals(item.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
