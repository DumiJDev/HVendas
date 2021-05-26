/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.modelos.property.ProdutoProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroItemVendaControlador implements Initializable {

    @FXML // fx:id="cbProduto"
    private JFXComboBox<ProdutoProperty> cbProduto; // Value injected by FXMLLoader

    @FXML // fx:id="tfQtd"
    private JFXTextField tfQtd; // Value injected by FXMLLoader

    @FXML // fx:id="btOk"
    private JFXButton btOk; // Value injected by FXMLLoader

    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
