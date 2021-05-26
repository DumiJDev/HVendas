/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import com.tecnoheli.hvendas.meufx.GeradorTela;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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

    @FXML // fx:id="lbCliente"
    private Label lbCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btClientes"
    private JFXButton btClientes; // Value injected by FXMLLoader


    @FXML // fx:id="lbCompra"
    private Label lbCompra; // Value injected by FXMLLoader

    @FXML // fx:id="btComprar"
    private JFXButton btComprar; // Value injected by FXMLLoader

    @FXML // fx:id="btAdCompra"
    private JFXButton btAdCompra; // Value injected by FXMLLoader

    @FXML // fx:id="lbProduto"
    private Label lbProduto; // Value injected by FXMLLoader

    @FXML // fx:id="btEstoque"
    private JFXButton btEstoque; // Value injected by FXMLLoader

    @FXML // fx:id="btAdProduto"
    private JFXButton btAdProduto; // Value injected by FXMLLoader

    @FXML // fx:id="lbFornecedor"
    private Label lbFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="btFornecedores"
    private JFXButton btFornecedores; // Value injected by FXMLLoader

    @FXML // fx:id="btAdFornecedor"
    private JFXButton btAdFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="lbFuncionario"
    private Label lbFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="btFuncionarios"
    private JFXButton btFuncionarios; // Value injected by FXMLLoader

    @FXML // fx:id="btAdFuncionario"
    private JFXButton btAdFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="lbVenda"
    private Label lbVenda; // Value injected by FXMLLoader

    @FXML // fx:id="btVender"
    private JFXButton btVender; // Value injected by FXMLLoader

    @FXML // fx:id="btAdVenda"
    private JFXButton btAdVenda; // Value injected by FXMLLoader

    @FXML // fx:id="lbNomeFuncionario"
    private Label lbNomeFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="btHome"
    private Button btHome; // Value injected by FXMLLoader

    @FXML // fx:id="apConteiner"
    private AnchorPane apConteiner; // Value injected by FXMLLoader

    @FXML // fx:id="apModo"
    private AnchorPane apModo; // Value injected by FXMLLoader

    @FXML // fx:id="apModo"
    private AnchorPane apHome; // Value injected by FXMLLoader

    @FXML // fx:id="rbModo"
    private JFXToggleButton rbModo; // Value injected by FXMLLoader

    @FXML // fx:id="btSair"
    private JFXButton btSair; // Value injected by FXMLLoader

    //Minhas Variáveis
    private ObservableList<JFXButton> bts;
    private ObservableMap<JFXButton, Parent> botaoTelas;
    private ObservableList<Label> etiquetas;
    private JFXButton btEscolhido;

    @FXML
    void escolhaMenu(ActionEvent event) {
        bts.forEach(botao -> {
            if (event.getSource() == botao)
                ativa(botao, botaoTelas.get(botao));
        });

        btEscolhido = (JFXButton) event.getSource();
    }

    @FXML
    void home(ActionEvent event) {
        btEscolhido = null;
        ativa(btEscolhido, apHome);
    }

    @FXML
    void sair(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GeradorTela loader = new GeradorTela();

        bts = FXCollections.observableArrayList(
                btClientes, btComprar, btEstoque,
                btFornecedores, btFuncionarios, btVender,
                btAdCompra, btAdProduto, btAdFornecedor,
                btAdFuncionario, btAdVenda
        );

        etiquetas = FXCollections.observableArrayList(
                lbCliente, lbCompra, lbNomeFuncionario,
                lbFuncionario, lbFornecedor, lbProduto,
                lbVenda
        );

        //vbContainerMenu.getChildren().removeIf(node -> node == btFuncionarios);

        botaoTelas = FXCollections.observableHashMap();

        IntStream.range(0, bts.size()).forEach(indice -> {
            if (indice < 6)
                botaoTelas.put(bts.get(indice), loader.lista(indice + 1));
            else
                botaoTelas.put(bts.get(indice), loader.cadastro(indice + 1));
        });

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

        if (tela != null) telaAtiva(tela);
        else apConteiner.getChildren().remove(botaoTelas.get(bt));
    }

    private void trocaModo() {
        final boolean estado = rbModo.isSelected();
        final String estilo = estado ? "/assets/css/global-claro.css" : "/assets/css/global-escuro.css";
        final String estiloGlobal = "/assets/css/global.css";

        apBarraMenu.getStylesheets().clear();
        apModo.getStylesheets().clear();
        vbContainerMenu.getStylesheets().clear();
        apConteiner.getStylesheets().clear();
        rbModo.getStylesheets().clear();

        apBarraMenu.getStylesheets().addAll(estiloGlobal, estilo);
        apModo.getStylesheets().addAll(estiloGlobal, estilo);
        vbContainerMenu.getStylesheets().addAll(estiloGlobal, estilo);
        apConteiner.getStylesheets().addAll(estiloGlobal, estilo);
        rbModo.getStylesheets().addAll(estiloGlobal, estilo);

        bts.forEach(botao -> {
            botao.getStylesheets().clear();
            botao.getStylesheets().addAll(estiloGlobal, estilo);
        });

        etiquetas.forEach(label -> {
            label.getStylesheets().clear();
            label.getStylesheets().addAll(estiloGlobal, estilo);
        });

        btAtivo(btEscolhido);
    }
}
