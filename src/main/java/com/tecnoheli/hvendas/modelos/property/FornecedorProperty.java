package com.tecnoheli.hvendas.modelos.property;

import java.util.List;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author TecnoHeli
 */
public class FornecedorProperty {

    private int codigo;
    private String nome;
    private String nif;

    private List<ProdutoProperty> produtos;
    private List<CompraProperty> compras;


}
