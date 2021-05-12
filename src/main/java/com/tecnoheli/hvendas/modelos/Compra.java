package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe contendo os dados da compra
 *
 * @author TecnoHeli
 */
public class Compra implements Serializable {

    private long codigo;
    private LocalDate dataCompra;

    private List<ItemCompra> itens;
    private Fornecedor fornecedor;
    private Funcionario funcionario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {

        return itens.stream().
                mapToDouble(
                        itemCompra -> itemCompra.getProduto().getPrecoVenda() * itemCompra.getQuantidade()).
                sum();
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void adItem(ItemCompra itemCompra) {
        itens.add(itemCompra);
    }

    public void removeItem(ItemCompra itemCompra) {
        itens.remove(itemCompra);
    }

    public int quantidadeItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return String.valueOf(this.codigo);
    }

}
