/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import com.tecnoheli.hvendas.LoginApp;
import com.tecnoheli.hvendas.models.Funcionario;
import com.tecnoheli.hvendas.util.meufx.GeradorTela;
import com.tecnoheli.hvendas.util.meufx.dialog.CadastroDialog;
import com.tecnoheli.hvendas.views.HVendasMainFX;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class TelaPrincipalControlador implements Initializable {

    private static String estilo = "/assets/css/global-escuro.css";
    private static String estiloGlobal;
    private static Funcionario funcionario;

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
    private JFXButton btSair; // Value injected by

    //Minhas Variáveis
    private ObservableList<JFXButton> bts;
    private ObservableList<Label> etiquetas;
    private JFXButton btEscolhido;
    private GeradorTela loader;

    public static String getEstilo() {
        return estilo;
    }

    public static String getEstiloGlobal() {
        return estiloGlobal;
    }

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario funcionario) {
        TelaPrincipalControlador.funcionario = funcionario;
    }

    @FXML
    void home(ActionEvent event) {
        btEscolhido = null;
        ativa(btEscolhido, apHome);
    }

    @FXML
    void sair(ActionEvent event) {
        Platform.runLater(() -> {
            try {
                Thread.sleep(1000);
                new LoginApp().start(new Stage());
                setFuncionario(null);
                HVendasMainFX.getHVendasStage().close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loader = new GeradorTela();

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

        if (funcionario != null)
            lbNomeFuncionario.textProperty().bind(new ReadOnlyObjectWrapper<>(funcionario.getBi().getNome()));
        else System.out.println(funcionario);

        //vbContainerMenu.getChildren().removeIf(node -> node == btFuncionarios);
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
    }

    @FXML
    void escolhaMenu(ActionEvent event) throws Exception {

        //Telas que mostram os dados
        IntStream.range(1, 7).forEach(value -> {
            if (event.getSource() == bts.get(value - 1))
                ativa((JFXButton) event.getSource(), loader.lista(value));
        });

        //Telas de cadastro os dados
        IntStream.range(7, 12).forEach(value -> {
            if (event.getSource() == bts.get(value - 1))
                ativa((JFXButton) event.getSource(), loader.cadastro(value));
        });

        if (btAdFornecedor == event.getSource()) {
            CadastroDialog.fornecedor();
        } else if (btAdFuncionario == event.getSource()) {
            CadastroDialog.funcionario();
        } else if (btAdProduto == event.getSource()) {
            CadastroDialog.produto();
        }

        btEscolhido = (JFXButton) event.getSource();
    }

    private void trocaModo() {
        final boolean estado = rbModo.isSelected();
        estilo = estado ? "/assets/css/global-claro.css" : "/assets/css/global-escuro.css";
        estiloGlobal = "/assets/css/global.css";

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

        rbModo.setText(!rbModo.isSelected() ? "Modo claro" : "Modo noturno");

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
