/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import com.tecnoheli.hvendas.meufx.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class TelaPrincipalControlador implements Initializable {

    @FXML // fx:id="apBarraMenu"
    private AnchorPane apBarraMenu; // Value injected by FXMLLoader

    @FXML // fx:id="vbContainerMenu"
    private VBox vbContainerMenu; // Value injected by FXMLLoader

    @FXML // fx:id="btClientes"
    private JFXButton btClientes; // Value injected by FXMLLoader

    @FXML // fx:id="btComprar"
    private JFXButton btComprar; // Value injected by FXMLLoader

    @FXML // fx:id="btEstoque"
    private JFXButton btEstoque; // Value injected by FXMLLoader

    @FXML // fx:id="btFornecedores"
    private JFXButton btFornecedores; // Value injected by FXMLLoader

    @FXML // fx:id="btFuncionarios"
    private JFXButton btFuncionarios; // Value injected by FXMLLoader

    @FXML // fx:id="btVender"
    private JFXButton btVender; // Value injected by FXMLLoader

    @FXML // fx:id="pTituloMenu"
    private Pane pTituloMenu; // Value injected by FXMLLoader

    @FXML // fx:id="lbNomeFuncionario"
    private Label lbNomeFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="apConteiner"
    private AnchorPane apConteiner; // Value injected by FXMLLoader

    @FXML // fx:id="apModo"
    private AnchorPane apModo; // Value injected by FXMLLoader

    @FXML // fx:id="rbModo"
    private JFXToggleButton rbModo; // Value injected by FXMLLoader

    //Minhas Variáveis
    private ObservableList<JFXButton> bts;
    private ObservableMap<JFXButton, Parent> botaoTelas;
    private JFXButton btEscolhido;

    @FXML
    void escolhaMenu(ActionEvent event) {
        bts.forEach(botao -> {
            if (event.getSource() == botao)
                ativa(botao, botaoTelas.get(botao));
        });

        btEscolhido = (JFXButton) event.getSource();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FXMLLoader loader = new FXMLLoader();

        bts = FXCollections.observableArrayList(
                btClientes, btComprar, btEstoque,
                btFornecedores, btFuncionarios, btVender
        );

        //vbContainerMenu.getChildren().removeIf(node -> node == btFuncionarios);

        botaoTelas = FXCollections.observableHashMap();


        for (int indice = 0; indice < 6; indice++) {
            botaoTelas.put(bts.get(indice), loader.lista(indice + 1));
        }

        rbModo.setOnAction(event -> trocaModo());

    }

    private void btAtivo(JFXButton bt) {
        final String estilo = "-fx-background-radius: 0; " +
                "-fx-background-color :  " + (rbModo.isSelected() ? "#c9c5c5" : "#342543")
                + "; -fx-border-width: 0 0 0 5; " +
                "-fx-border-color: " + (rbModo.isSelected() ? "#000;" : "#0e73e5;");

        bts.forEach(botao -> botao.setStyle(botao == bt ? estilo : ""));
    }

    private void telaAtiva(Parent tela) {
        AnchorPane.setBottomAnchor(tela, .0);
        AnchorPane.setLeftAnchor(tela, .0);
        AnchorPane.setRightAnchor(tela, .0);
        AnchorPane.setTopAnchor(tela, .0);
        apConteiner.getChildren().removeIf(Objects::nonNull);
        apConteiner.getChildren().add(tela);
    }

    private void ativa(JFXButton bt, Parent tela) {
        btAtivo(bt);
        telaAtiva(tela);
    }

    private void trocaModo() {
        final var estado = rbModo.isSelected();
        final var estilo = estado ? "/assets/css/global-claro.css" : "/assets/css/global-escuro.css";
        final var estiloGlobal = "/assets/css/global.css";

        apBarraMenu.getStylesheets().clear();
        apModo.getStylesheets().clear();
        vbContainerMenu.getStylesheets().clear();
        btClientes.getStylesheets().clear();
        btComprar.getStylesheets().clear();
        btEstoque.getStylesheets().clear();
        btFornecedores.getStylesheets().clear();
        btFuncionarios.getStylesheets().clear();
        btVender.getStylesheets().clear();
        pTituloMenu.getStylesheets().clear();
        lbNomeFuncionario.getStylesheets().clear();
        apConteiner.getStylesheets().clear();
        rbModo.getStylesheets().clear();

        apBarraMenu.getStylesheets().addAll(estiloGlobal, estilo);
        apModo.getStylesheets().addAll(estiloGlobal, estilo);
        vbContainerMenu.getStylesheets().addAll(estiloGlobal, estilo);
        btClientes.getStylesheets().addAll(estiloGlobal, estilo);
        btComprar.getStylesheets().addAll(estiloGlobal, estilo);
        btEstoque.getStylesheets().addAll(estiloGlobal, estilo);
        btFornecedores.getStylesheets().addAll(estiloGlobal, estilo);
        btFuncionarios.getStylesheets().addAll(estiloGlobal, estilo);
        btVender.getStylesheets().addAll(estiloGlobal, estilo);
        pTituloMenu.getStylesheets().addAll(estiloGlobal, estilo);
        lbNomeFuncionario.getStylesheets().addAll(estiloGlobal, estilo);
        apConteiner.getStylesheets().addAll(estiloGlobal, estilo);
        rbModo.getStylesheets().addAll(estiloGlobal, estilo);

        btAtivo(btEscolhido);
    }
}
