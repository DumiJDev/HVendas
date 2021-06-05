package com.tecnoheli.hvendas.models.property;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Classe de relação entre a compra e o produto
 *
 * @author TecnoHeli
 */
public class ItemProperty<T> {

    private final SimpleLongProperty codigo;
    private final SimpleLongProperty quantidade;

    private final SimpleStringProperty nome;
    private final SimpleDoubleProperty preco;
    private final SimpleDoubleProperty total;

    public ItemProperty(long codigo, long quantidade, String nome, double preco) {
        this.codigo = new SimpleLongProperty(codigo);
        this.quantidade = new SimpleLongProperty(quantidade);
        this.nome = new SimpleStringProperty(nome);
        this.preco = new SimpleDoubleProperty(preco);
        this.total = new SimpleDoubleProperty(preco * quantidade);
    }

    public long getCodigo() {
        return codigo.get();
    }

    public SimpleLongProperty codigoProperty() {
        return codigo;
    }

    public long getQuantidade() {
        return quantidade.get();
    }

    public SimpleLongProperty quantidadeProperty() {
        return quantidade;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public double getPreco() {
        return preco.get();
    }

    public SimpleDoubleProperty precoProperty() {
        return preco;
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void aumenta(long quantidade) {
        quantidadeProperty().set(getQuantidade() + quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemProperty)) return false;
        ItemProperty<?> that = (ItemProperty<?>) o;
        return codigo.get() == that.codigo.get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo.get());
    }
}
