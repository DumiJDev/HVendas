package com.tecnoheli.hvendas.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Classe contendo os dados da venda
 *
 * @author TecnoHeli
 */
public class Venda implements Serializable {

    private int codigo;
    private LocalDate dataVenda;

    private Cliente cliente;
    private List<ItemVenda> itens;
    private Funcionario funcionario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return itens.stream().
                mapToDouble(
                        itemVenda -> itemVenda.getProduto().getPrecoVenda() * itemVenda.getQuantidade()).
                sum();
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void adItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public void removeItem(ItemVenda itemVenda) {
        itens.remove(itemVenda);
    }

    public int quantidadeItens() {
        return itens.size();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return getCodigo() == venda.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
}
