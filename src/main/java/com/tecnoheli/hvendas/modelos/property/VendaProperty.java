package com.tecnoheli.hvendas.modelos.property;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe contendo os dados da venda
 *
 * @author TecnoHeli
 */
public class VendaProperty {

    private int codigo;
    private LocalDate dataVenda;

    private ClienteProperty cliente;
    private List<ItemVendaProperty> itens;
    private FuncionarioProperty funcionario;


}
