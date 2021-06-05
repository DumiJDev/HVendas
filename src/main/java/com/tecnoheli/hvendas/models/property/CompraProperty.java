package com.tecnoheli.hvendas.models.property;

import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * Classe contendo os dados da compra
 *
 * @author TecnoHeli
 */
public class CompraProperty {

    private long codigo;
    private StringProperty dataCompra;

    private List<ItemProperty> itens;
    private FornecedorProperty fornecedor;
    private FuncionarioProperty funcionario;

}
