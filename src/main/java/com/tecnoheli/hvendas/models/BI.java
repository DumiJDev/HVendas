package com.tecnoheli.hvendas.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class BI implements Serializable {

    @Column(name = "numero_BI", length = 13, nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nomeDoPai;

    @Column(nullable = false)
    private String nomeDaMae;

    @Column(nullable = false)
    private String residencia;

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    @Enumerated(value = EnumType.STRING)
    private Sexo sexo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BI)) return false;
        BI bi = (BI) o;
        return getNumero().equals(bi.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public String toString() {
        return "BI{" +
                "numero='" + numero + '\'' +
                ", nome='" + nome + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                ", residência='" + residencia + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", sexo=" + sexo +
                '}';
    }
}
