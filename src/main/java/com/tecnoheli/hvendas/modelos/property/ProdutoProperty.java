package com.tecnoheli.hvendas.modelos.property;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe contendo os dados do produto
 *
 * @author TecnoHeli
 */
public class ProdutoProperty {

    private int codigo;
    private StringProperty nome;
    private DoubleProperty precoCompra;
    private DoubleProperty precoVenda;

    private EstoqueProperty estoque;

    
}
