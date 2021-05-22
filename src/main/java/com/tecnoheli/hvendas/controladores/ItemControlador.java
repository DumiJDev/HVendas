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
    private static int nTotalItem = 0;
    private static Label[] labels;
    private int nItem;

    public static void setLabels(Label[] labels) {
        ItemControlador.labels = labels;
    }

    @FXML
    void click(ActionEvent event) {
        if (event.getSource() == btDel) {
            ItemControlador.nTotalItem--;
            ListaClienteControlador.deleta(this.nItem);
        } else if (event.getSource() == btVista) {
            System.out.println(btVista);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nItem = ItemControlador.nTotalItem++;

        adicionaElementos(labels);
    }

    private void adicionaElementos(Label[] lbs){
        gpContainer.getChildren().clear();
        gpContainer.getColumnConstraints().clear();

        ColumnConstraints c = new ColumnConstraints();
        c.prefWidthProperty().bind(gpContainer.widthProperty().divide(lbs.length));
        c.setHalignment(HPos.CENTER);

        for (int i = 0; i < lbs.length; i++)
            gpContainer.getColumnConstraints().add(c);

        gpContainer.addRow(0, lbs);
    }
}
