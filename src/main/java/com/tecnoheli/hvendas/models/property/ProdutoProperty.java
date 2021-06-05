package com.tecnoheli.hvendas.models.property;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Classe contendo os dados do produto
 *
 * @author TecnoHeli
 */
public class ProdutoProperty {

    private final SimpleLongProperty codigo;
    private final SimpleStringProperty nome;
    private final SimpleDoubleProperty precoCompra;
    private final SimpleDoubleProperty precoVenda;
    private final SimpleLongProperty estoque;


    public ProdutoProperty(long codigo, String nome, Double precoCompra, Double precoVenda, long estoque) {
        this.codigo = new SimpleLongProperty(codigo);
        this.nome = new SimpleStringProperty(nome);
        this.precoCompra = new SimpleDoubleProperty(precoCompra);
        this.precoVenda = new SimpleDoubleProperty(precoVenda);
        this.estoque = new SimpleLongProperty(estoque);
    }

    public long getCodigo() {
        return codigo.get();
    }

    public SimpleLongProperty codigoProperty() {
        return codigo;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public double getPrecoCompra() {
        return precoCompra.get();
    }

    public SimpleDoubleProperty precoCompraProperty() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda.get();
    }

    public SimpleDoubleProperty precoVendaProperty() {
        return precoVenda;
    }

    public long getEstoque() {
        return estoque.get();
    }

    public SimpleLongProperty estoqueProperty() {
        return estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoProperty)) return false;
        ProdutoProperty that = (ProdutoProperty) o;
        return codigo.equals(that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return nome.get();
    }
}
