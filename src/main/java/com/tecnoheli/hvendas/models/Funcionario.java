/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author TecnoHeli
 */
@Entity
@Table(name = "Funcionarios")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Column(nullable = false, scale = 3)
    private Double salario;

    @Embedded
    private BI bi;

    public long getCodigo() {
        return codigo;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public BI getBi() {
        return bi;
    }

    public void setBi(BI bi) {
        this.bi = bi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        return codigo == ((Funcionario) o).codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

}
