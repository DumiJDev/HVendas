/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.meufx.FXMLLoader;
import com.tecnoheli.hvendas.modelos.property.ClienteProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader


    private FXMLLoader loader;

    public static void deleta(int nItem) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbNome.setOnAction(event -> tfPesquisa.setPromptText("Digite o nome"));
        rbTelefone.setOnAction(event -> tfPesquisa.setPromptText("Digite o telefone"));
        //tfPesquisa.setOnAction(event -> vbItem.getChildren().addAll(resultado()));


        try {
            Node node = javafx.fxml.FXMLLoader.load(getClass().getResource("/fxml/item.fxml"));
            Node node1 = javafx.fxml.FXMLLoader.load(getClass().getResource("/fxml/item.fxml"));

            adiciona(node, node1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ClienteProperty resultado() {
        return new ClienteProperty("1", "Pauol", "89379274");
    }

    private void adiciona(Node...itens) {
        for (Node item: itens) {
            AnchorPane.setRightAnchor(item, .0);
            AnchorPane.setLeftAnchor(item, .0);
            AnchorPane.setTopAnchor(item, apContainer.getChildren().size() * 45.0);
            apContainer.getChildren().add(item);
        }
    }

}
