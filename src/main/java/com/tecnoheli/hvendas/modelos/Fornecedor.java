package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author TecnoHeli
 */
public class Fornecedor implements Serializable {

    private int codigo;
    private String nome;
    private String nif;

    private List<Produto> produtos;
    private List<Compra> compras;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
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
