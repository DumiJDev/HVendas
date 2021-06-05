/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.models.Funcionario;
import com.tecnoheli.hvendas.models.dao.FuncionarioDAO;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class ListaFuncionarioControlador implements Initializable {

    //Minhas Variáveis
    private static FuncionarioDAO dao;
    private static AnchorPane container;

    @FXML // fx:id="tfPesquisa"
    private JFXTextField tfPesquisa; // Value injected by FXMLLoader
    @FXML // fx:id="rbFuncao"
    private JFXRadioButton rbFuncao; // Value injected by FXMLLoader
    @FXML // fx:id="OpcaoPesquisa"
    private ToggleGroup OpcaoPesquisa; // Value injected by FXMLLoader
    @FXML // fx:id="rbNome"
    private JFXRadioButton rbNome; // Value injected by FXMLLoader
    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader
    @FXML // fx:id="gpCabecalho"
    private GridPane gpCabecalho; // Value injected by FXMLLoader

    public static void deleta(Object id) {
        dao.excluir(id, Funcionario.class);
        System.out.printf("Você deletou %s%n", id);
        atualizaLista(dao.listarTodos());
    }

    private static void adiciona(Node... itens) {
        Arrays.stream(itens).forEach(item -> {
            AnchorPane.setRightAnchor(item, .0);
            AnchorPane.setLeftAnchor(item, .0);
            AnchorPane.setTopAnchor(item, container.getChildren().size() * 45.0);
            container.getChildren().add(item);
        });
    }

    private static Parent novoItem(Label... lbs) throws IOException {
        ItemControlador.setLabels(lbs);
        ItemControlador.setTipo(ItemTipo.Funcionario);
        return javafx.fxml.FXMLLoader.load(ListaFuncionarioControlador.class.getResource("/fxml/item.fxml"));
    }

    private static void atualizaLista(List<Funcionario> funcionarios) {
        container.getChildren().clear();
        try {
            if (!funcionarios.isEmpty()) {
                final var itens = new Parent[(int) dao.conta()];

                for (int i = 0; i < funcionarios.size(); i++) {
                    final var funcionario = funcionarios.get(i);
                    ItemControlador.setId(funcionario.getCodigo());
                    itens[i] = novoItem(new Label(funcionario.getBi().getNome()),
                            new Label(funcionario.getFuncao().name()));
                }
                adiciona(itens);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new FuncionarioDAO();

        rbNome.setOnAction(event -> tfPesquisa.setPromptText("Encontre o funcionário pelo nome"));
        rbFuncao.setOnAction(event -> tfPesquisa.setPromptText("Encontre o funcionário pela função"));
        tfPesquisa.setOnKeyPressed(keyEvent -> atualizaLista(resultado()));
        tfPesquisa.setOnKeyReleased(keyEvent -> atualizaLista(resultado()));

        container = apContainer;

        final Label[] labels = {new Label("Nome"), new Label("Função")};

        configuraLabel(labels);
        adicionaElementos(labels);

        atualizaLista(dao.listarTodos());
    }

    private List<Funcionario> resultado() {
        final var resultado = new ArrayList<Funcionario>();

        if (rbNome.isSelected())
            dao.listarTodosComNomeContendo(tfPesquisa.getText()).forEachRemaining(resultado::add);
        else if (rbFuncao.isSelected())
            dao.listarTodosComFuncaoContendo(tfPesquisa.getText()).forEachRemaining(resultado::add);

        return resultado;
    }

    private void adicionaElementos(Label... lbs) {
        gpCabecalho.getChildren().clear();
        gpCabecalho.getColumnConstraints().clear();

        ColumnConstraints c = new ColumnConstraints();
        c.prefWidthProperty().bind(gpCabecalho.widthProperty().divide(lbs.length));
        c.setHalignment(HPos.CENTER);

        for (int i = 0; i < lbs.length; i++)
            gpCabecalho.getColumnConstraints().add(c);

        gpCabecalho.addRow(0, lbs);
    }

    private void configuraLabel(Label... lbs) {
        final String estilo = "-fx-text-fill: #0e73e5;";
        final Font fonte = Font.font("System Bold", 16);
        Arrays.stream(lbs).forEach(label -> {
            label.setStyle(estilo);
            label.setFont(fonte);
        });
    }

}
