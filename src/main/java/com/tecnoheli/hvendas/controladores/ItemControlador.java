package com.tecnoheli.hvendas.controladores;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class ItemControlador implements Initializable {

    @FXML // fx:id="gpContainer"
    private GridPane gpContainer; // Value injected by FXMLLoader

    @FXML // fx:id="btVista"
    private JFXButton btVista; // Value injected by FXMLLoader

    @FXML // fx:id="btDel"
    private JFXButton btDel; // Value injected by FXMLLoader

    //Minhas Variáveis
    private static Label[] labels;
    private static ItemTipo tipo;
    private ItemTipo itemTipo;
    //Controlo do ID
    private static String idString;
    private static long idLong;

    @FXML
    void click(ActionEvent event) {
        if (event.getSource() == btDel) {
            /**switch (itemTipo) {
                case Cliente:
                    ListaClienteControlador.deleta(idString);
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
             */
        } else if (event.getSource() == btVista) {
            /**switch (itemTipo) {
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
            }*/
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemTipo = tipo;
        configuraLabel(labels);
        adicionaElementos(labels);
    }

    private void adicionaElementos(Label...lbs){
        gpContainer.getChildren().clear();
        gpContainer.getColumnConstraints().clear();

        ColumnConstraints c = new ColumnConstraints();
        c.prefWidthProperty().bind(gpContainer.widthProperty().divide(lbs.length));
        c.setHalignment(HPos.CENTER);

        for (int i = 0; i < lbs.length; i++)
            gpContainer.getColumnConstraints().add(c);

        gpContainer.addRow(0, lbs);
    }

    private void configuraLabel(Label...lbs){
        final String estilo = "-fx-text-fill: #0e73e5;";
        final Font fonte = Font.font("System Bold", 14);
        Arrays.stream(lbs).forEach(label -> {
            label.setStyle(estilo);
            label.setFont(fonte);
        });
    }

    public static void setLabels(Label[] labels) {
        ItemControlador.labels = labels;
    }

    public static void setIdString(String idString) {
        ItemControlador.idString = idString;
    }

    public static void setIdLong(long idLong) {
        ItemControlador.idLong = idLong;
    }
}
