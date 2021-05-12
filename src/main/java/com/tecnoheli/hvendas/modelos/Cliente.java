package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Classe contendo os dados do cliente
 *
 * @author TecnoHeli
 */
public class Cliente implements Serializable {

    private String id;
    private String nome;
    private String telefone;

    private List<Venda> compras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void setCompras(List<Venda> compras) {
        this.compras = compras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getId().equals(cliente.getId()) ||
                getTelefone().equals(cliente.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTelefone());
    }
}
