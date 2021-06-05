package com.tecnoheli.hvendas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe contendo os dados do cliente
 *
 * @author TecnoHeli
 */
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 9)
    @Id
    private String telefone;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getTelefone().equals(cliente.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTelefone());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
