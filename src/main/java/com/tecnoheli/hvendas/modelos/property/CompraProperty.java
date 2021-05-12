package com.tecnoheli.hvendas.modelos.property;

import java.util.List;
import javafx.beans.property.StringProperty;

/**
 * Classe contendo os dados da compra
 *
 * @author TecnoHeli
 */
public class CompraProperty {

    private long codigo;
    private StringProperty dataCompra;

    private List<ItemCompraProperty> itens;
    private FornecedorProperty fornecedor;
    private FuncionarioProperty funcionario;

}
