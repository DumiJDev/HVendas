package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ItemControlador implements Initializable {

    //Minhas Variáveis
    private static Label[] labels;
    private static ItemTipo tipo;
    private ItemTipo itemTipo;
    private Object idObject;

    //Controlo do ID
    private static Object id;

    @FXML // fx:id="gpContainer"
    private GridPane gpContainer; // Value injected by FXMLLoader
    @FXML // fx:id="btVista"
    private JFXButton btVista; // Value injected by FXMLLoader
    @FXML // fx:id="btDel"
    private JFXButton btDel; // Value injected by FXMLLoader


    public static void setLabels(Label[] labels) {
        ItemControlador.labels = labels;
    }

    public static void setId(Object id) {
        ItemControlador.id = id;
    }

    public static void setTipo(ItemTipo tipo) {
        ItemControlador.tipo = tipo;
    }

    @FXML
    void click(ActionEvent event) {
        if (event.getSource() == btDel) {
            switch (itemTipo) {
                case Cliente:
                    ListaClienteControlador.deleta(idObject);
                    break;
                case Compra:
                    ListaCompraControlador.deleta(idObject);
                    break;
                case Fornecedor:
                    ListaFornecedorControlador.deleta(idObject);
                    break;
                case Funcionario:
                    ListaFuncionarioControlador.deleta(idObject);
                    break;
                case Produto:
                    ListaProdutoControlador.deleta(idObject);
                    break;
                case Venda:
                    ListaVendaControlador.deleta(idObject);
                    break;
                default:
                    throw new IllegalStateException("Valor inesperado: " + itemTipo);
            }
        } else if (event.getSource() == btVista) {
            switch (itemTipo) {
                case Cliente:
                    break;
                case Compra:
                    break;
                case Fornecedor:
                    break;
                case Funcionario:
                    break;
                case Produto:
                    break;
                case Venda:
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemTipo = tipo;
        idObject = id;
        configuraLabel(labels);
        adicionaElementos(labels);
    }

    private void adicionaElementos(Label... lbs) {
        gpContainer.getChildren().clear();
        gpContainer.getColumnConstraints().clear();

        ColumnConstraints c = new ColumnConstraints();
        c.prefWidthProperty().bind(gpContainer.widthProperty().divide(lbs.length));
        c.setHalignment(HPos.CENTER);

        for (int i = 0; i < lbs.length; i++)
            gpContainer.getColumnConstraints().add(c);

        gpContainer.addRow(0, lbs);
    }

    private void configuraLabel(Label... lbs) {
        final String estilo = "-fx-text-fill: #0e73e5;";
        final Font fonte = Font.font("System Bold", 14);
        Arrays.stream(lbs).forEach(label -> {
            label.setStyle(estilo);
            label.setFont(fonte);
        });
    }
}
