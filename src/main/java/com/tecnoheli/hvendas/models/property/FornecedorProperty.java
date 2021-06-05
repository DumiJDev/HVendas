package com.tecnoheli.hvendas.models.property;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author TecnoHeli
 */
public class FornecedorProperty {

    private final SimpleStringProperty nif;
    private final SimpleStringProperty nome;

    public FornecedorProperty(String nome, String nif) {
        this.nif = new SimpleStringProperty(nif);
        this.nome = new SimpleStringProperty(nome);
    }

    public String getNif() {
        return nif.get();
    }

    public SimpleStringProperty nifProperty() {
        return nif;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FornecedorProperty)) return false;
        FornecedorProperty that = (FornecedorProperty) o;
        return nif.equals(that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    @Override
    public String toString() {
        return nome.get();
    }

}
