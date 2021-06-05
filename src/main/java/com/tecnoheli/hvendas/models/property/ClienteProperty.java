package com.tecnoheli.hvendas.models.property;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Classe contendo os dados do cliente
 *
 * @author TecnoHeli
 */
public class ClienteProperty {

    private final SimpleStringProperty nome;
    private final SimpleStringProperty telefone;

    public ClienteProperty(String nome, String telefone) {
        this.nome = new SimpleStringProperty(nome);
        this.telefone = new SimpleStringProperty(telefone);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteProperty)) return false;
        ClienteProperty that = (ClienteProperty) o;
        return telefone.equals(that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }

    @Override
    public String toString() {
        return nome.get();
    }
}
