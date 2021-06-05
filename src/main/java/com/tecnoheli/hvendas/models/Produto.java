package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe contendo os dados do produto
 *
 * @author TecnoHeli
 */
@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "preco_compra", scale = 3, nullable = false)
    private Double precoCompra;

    @Column(name = "preco_venda", scale = 3, nullable = false)
    private Double precoVenda;

    @Embedded
    private Estoque estoque;

    public Produto() {
    }

    public long getCodigo() {
        return codigo;
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
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
