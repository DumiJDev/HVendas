/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class ListaFornecedorControlador implements Initializable {

    @FXML // fx:id="tfPesquisa"
    private JFXTextField tfPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbNIF"
    private JFXRadioButton rbNIF; // Value injected by FXMLLoader

    @FXML // fx:id="OpcaoPesquisa"
    private ToggleGroup OpcaoPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbNome"
    private JFXRadioButton rbNome; // Value injected by FXMLLoader

    @FXML // fx:id="btAdFornecedor"
    private JFXButton btAdFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="rbProduto"
    private JFXRadioButton rbProduto; // Value injected by FXMLLoader

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="gpCabecalho"
    private GridPane gpCabecalho; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
