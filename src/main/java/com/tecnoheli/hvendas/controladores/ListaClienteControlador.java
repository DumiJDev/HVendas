/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.meufx.FXMLLoader;
import com.tecnoheli.hvendas.modelos.property.ClienteProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class ListaClienteControlador implements Initializable {

    @FXML // fx:id="tfPesquisa"
    private JFXTextField tfPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbTelefone"
    private JFXRadioButton rbTelefone; // Value injected by FXMLLoader

    @FXML // fx:id="OpcaoPesquisa"
    private ToggleGroup OpcaoPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbNome"
    private JFXRadioButton rbNome; // Value injected by FXMLLoader

    @FXML // fx:id="btAdCliente"
    private JFXButton btAdCliente; // Value injected by FXMLLoader

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="gpCabecalho"
    private GridPane gpCabecalho; // Value injected by FXMLLoader

    public static void deleta(int nItem) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbNome.setOnAction(event -> tfPesquisa.setPromptText("Encontre o cliente pelo nome"));
        rbTelefone.setOnAction(event -> tfPesquisa.setPromptText("Encontre o cliente pelo telefone"));
        //tfPesquisa.setOnAction(event -> vbItem.getChildren().addAll(resultado()));

        try {
            adiciona(novoItem(), novoItem(), novoItem(), novoItem());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ClienteProperty resultado() {
        return new ClienteProperty("1", "Pauol", "89379274");
    }

    private void adiciona(Node...itens) {
        Arrays.stream(itens).forEach(item -> {
            AnchorPane.setRightAnchor(item, .0);
            AnchorPane.setLeftAnchor(item, .0);
            AnchorPane.setTopAnchor(item, apContainer.getChildren().size() * 47.0);
            apContainer.getChildren().add(item);
        });
    }

    private Parent novoItem() throws IOException {
        Label[] lb = {new Label("Oi!!!"), new Label("Hello!!!")};
        ItemControlador.setLabels(lb);
        return javafx.fxml.FXMLLoader.load(getClass().getResource("/fxml/item.fxml"));
    }

}
