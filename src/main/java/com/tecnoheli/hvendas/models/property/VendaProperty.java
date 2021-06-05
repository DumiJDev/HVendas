package com.tecnoheli.hvendas.models.property;

import com.tecnoheli.hvendas.models.Venda;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe contendo os dados da venda
 *
 * @author TecnoHeli
 */
public class VendaProperty {

    private int codigo;
    private LocalDateTime dataVenda;

    private ClienteProperty cliente;
    private List<ItemProperty<Venda>> itens;
    private FuncionarioProperty funcionario;


}
