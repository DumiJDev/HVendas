package com.tecnoheli.hvendas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe contendo os dados da compra
 *
 * @author TecnoHeli
 */
@Entity
@Table(name = "Compras")
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    @JoinTable
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Item> itens;

    @JoinColumn(name = "fornecedor")
    @ManyToOne
    private Fornecedor fornecedor;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Funcionario funcionario;

    public Compra() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void adItem(Item item) {
        itens.add(item);
    }

    public void removeItem(Item item) {
        itens.remove(item);
    }

    public int quantidadeItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return itens.toString();
    }

}
