package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Estoque implements Serializable {

    private long id;
    private long quantidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public long zerar() {
        this.quantidade -= this.quantidade;
        return getQuantidade();
    }

    public long diminui(long tamanho){
        this.quantidade -= tamanho;
        return getQuantidade();
    };

    public long aumenta(long tamanho){
        this.quantidade += tamanho;
        return getQuantidade();
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estoque)) return false;
        Estoque estoque = (Estoque) o;
        return getId() == estoque.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "quantidade=" + quantidade +
                '}';
    }
}
