/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class ListaProdutoControlador implements Initializable {

    @FXML // fx:id="apCabecalho"
    private AnchorPane apCabecalho; // Value injected by FXMLLoader

    @FXML // fx:id="tfPesquisa"
    private JFXTextField tfPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbPreco"
    private JFXRadioButton rbPreco; // Value injected by FXMLLoader

    @FXML // fx:id="OpcaoPesquisa"
    private ToggleGroup OpcaoPesquisa; // Value injected by FXMLLoader

    @FXML // fx:id="rbNome"
    private JFXRadioButton rbNome; // Value injected by FXMLLoader

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="gpCabecalho"
    private GridPane gpCabecalho; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final Label[] labels = {new Label("Nome"), new Label("Preço"), new Label("Qtd (Stock)")};

        configuraLabel(labels);
        adicionaElementos(labels);

        try {
            adiciona(novoItem(), novoItem(), novoItem(), novoItem());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void adiciona(Node... itens) {
        Arrays.stream(itens).forEach(item -> {
            AnchorPane.setRightAnchor(item, .0);
            AnchorPane.setLeftAnchor(item, .0);
            AnchorPane.setTopAnchor(item, apContainer.getChildren().size() * 45.0);
            apContainer.getChildren().add(item);
        });
    }

    private Parent novoItem(Label...lbs) throws IOException {
        Label[] lb = {new Label("Bolacha Maria"), new Label("250,00 Akz"), new Label("10")};
        ItemControlador.setLabels(lb);
        return javafx.fxml.FXMLLoader.load(getClass().getResource("/fxml/item.fxml"));
    }

    private void adicionaElementos(Label...lbs){
        gpCabecalho.getChildren().clear();
        gpCabecalho.getColumnConstraints().clear();

        ColumnConstraints c = new ColumnConstraints();
        c.prefWidthProperty().bind(gpCabecalho.widthProperty().divide(lbs.length));
        c.setHalignment(HPos.CENTER);

        for (int i = 0; i < lbs.length; i++)
            gpCabecalho.getColumnConstraints().add(c);

        gpCabecalho.addRow(0, lbs);
    }

    private void configuraLabel(Label...lbs){
        final String estilo = "-fx-text-fill: #0e73e5;";
        final Font fonte = Font.font("System Bold", 16);
        Arrays.stream(lbs).forEach(label -> {
            label.setStyle(estilo);
            label.setFont(fonte);
        });
    }
    
}
