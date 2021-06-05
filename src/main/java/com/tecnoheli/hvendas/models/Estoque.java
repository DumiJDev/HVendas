package com.tecnoheli.hvendas.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Estoque implements Serializable {

    @Column(name = "qtd_stock")
    private long quantidade;

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

    public long diminui(long qtd) {
        this.quantidade -= qtd;
        return getQuantidade();
    }

    public long aumenta(long tamanho) {
        this.quantidade += tamanho;
        return getQuantidade();
    }

    ;


    @Override
    public String toString() {
        return "Estoque{" +
                "quantidade=" + quantidade +
                '}';
    }
}
