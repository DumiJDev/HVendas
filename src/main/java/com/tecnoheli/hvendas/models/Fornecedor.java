package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author TecnoHeli
 */
@Entity
@Table(name = "Fornecedores")
public class Fornecedor implements Serializable {

    @Column(name = "nome_funcionario", nullable = false)
    private String nome;

    @Id
    @Column(name = "NIF", nullable = false)
    private String nif;

    @JoinTable
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return getNif().equals(that.getNif());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNif());
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}
