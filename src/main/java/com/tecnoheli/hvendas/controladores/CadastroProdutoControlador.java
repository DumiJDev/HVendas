/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroProdutoControlador implements Initializable {

    @FXML // fx:id="tfNomeProduto"
    private JFXTextField tfNomeProduto; // Value injected by FXMLLoader

    @FXML // fx:id="tfPrecoCompra"
    private JFXTextField tfPrecoCompra; // Value injected by FXMLLoader

    @FXML // fx:id="tfPrecoVenda"
    private JFXTextField tfPrecoVenda; // Value injected by FXMLLoader

    @FXML // fx:id="btAdicionar"
    private JFXButton btAdicionar; // Value injected by FXMLLoader

    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    @FXML
    void adicionar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void valida(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
