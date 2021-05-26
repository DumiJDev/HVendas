/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.modelos.property.ProdutoProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroFornecedorControlador implements Initializable {

    @FXML // fx:id="tfNomeFornecedor"
    private JFXTextField tfNomeFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="tfNIF"
    private JFXTextField tfNIF; // Value injected by FXMLLoader

    @FXML // fx:id="cbProdutos"
    private JFXComboBox<ProdutoProperty> cbProdutos; // Value injected by FXMLLoader

    @FXML // fx:id="apProdutos"
    private AnchorPane apProdutos; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
