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
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.modelos.Funcao;
import com.tecnoheli.hvendas.modelos.property.FuncionarioProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroFuncionarioControlador implements Initializable {

    @FXML // fx:id="tfUsername"
    private JFXTextField tfUsername; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeFuncionario"
    private JFXTextField tfNomeFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomePai"
    private JFXTextField tfNomePai; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeMae"
    private JFXTextField tfNomeMae; // Value injected by FXMLLoader

    @FXML // fx:id="tfResidencia"
    private JFXTextField tfResidencia; // Value injected by FXMLLoader

    @FXML // fx:id="cbSexo"
    private JFXComboBox<FuncionarioProperty> cbSexo; // Value injected by FXMLLoader

    @FXML // fx:id="tfNBI"
    private JFXTextField tfNBI; // Value injected by FXMLLoader

    @FXML // fx:id="dpDataNascimento"
    private DatePicker dpDataNascimento; // Value injected by FXMLLoader

    @FXML // fx:id="cbCargo"
    private JFXComboBox<Funcao> cbCargo; // Value injected by FXMLLoader

    @FXML // fx:id="btAd"
    private JFXButton btAd; // Value injected by FXMLLoader

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
