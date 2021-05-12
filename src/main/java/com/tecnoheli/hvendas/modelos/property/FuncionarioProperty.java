/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.modelos.property;

import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;

/**
 * @author TecnoHeli
 */
public class FuncionarioProperty {

    private LongProperty codigo;
    private FuncaoProperty funcao;
    private DoubleProperty salario;

    private BIProperty bi;
    private List<VendaProperty> vendas;
    private List<CompraProperty> compras;
    private UsuarioProperty usuario;

   
}
