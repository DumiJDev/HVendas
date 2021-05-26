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
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.modelos.property.FornecedorProperty;
import com.tecnoheli.hvendas.modelos.property.ItemCompraProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroCompraControlador implements Initializable {

    @FXML // fx:id="tvProdutos"
    private TableView<ItemCompraProperty> tvProdutos; // Value injected by FXMLLoader

    @FXML // fx:id="cvNome"
    private TableColumn<ItemCompraProperty, String> cvNome; // Value injected by FXMLLoader

    @FXML // fx:id="cvQuantidade"
    private TableColumn<ItemCompraProperty, Integer> cvQuantidade; // Value injected by FXMLLoader

    @FXML // fx:id="cbPreco"
    private TableColumn<ItemCompraProperty, Double> cbPreco; // Value injected by FXMLLoader

    @FXML // fx:id="ctTotal"
    private TableColumn<ItemCompraProperty, Double> ctTotal; // Value injected by FXMLLoader

    @FXML // fx:id="rbCasa"
    private JFXRadioButton rbCasa; // Value injected by FXMLLoader

    @FXML // fx:id="tgCliente"
    private ToggleGroup tgFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="rbNovo"
    private JFXRadioButton rbNovo; // Value injected by FXMLLoader

    @FXML // fx:id="cbClientes"
    private JFXComboBox<FornecedorProperty> cbClientes; // Value injected by FXMLLoader

    @FXML // fx:id="tfNome"
    private JFXTextField tfNome; // Value injected by FXMLLoader

    @FXML // fx:id="tfTelefone"
    private JFXTextField tfTelefone; // Value injected by FXMLLoader

    @FXML // fx:id="btAdProd"
    private JFXButton btAdProd; // Value injected by FXMLLoader

    @FXML // fx:id="btAtProd"
    private JFXButton btAtProd; // Value injected by FXMLLoader

    @FXML // fx:id="btLimpLista"
    private JFXButton btLimpLista; // Value injected by FXMLLoader

    @FXML // fx:id="btElProd"
    private JFXButton btElProd; // Value injected by FXMLLoader

    @FXML // fx:id="lbTotal"
    private Label lbTotal; // Value injected by FXMLLoader

    @FXML // fx:id="btConcluido"
    private JFXButton btConcluido; // Value injected by FXMLLoader

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
