package com.tecnoheli.hvendas.controladores;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemControlador implements Initializable {

    @FXML // fx:id="gpContainer"
    private GridPane gpContainer; // Value injected by FXMLLoader

    @FXML // fx:id="lbCampo1"
    private Label lbCampo1; // Value injected by FXMLLoader

    @FXML // fx:id="lbCampo2"
    private Label lbCampo2; // Value injected by FXMLLoader

    @FXML // fx:id="lbCampo3"
    private Label lbCampo3; // Value injected by FXMLLoader

    @FXML // fx:id="btDel"
    private JFXButton btDel; // Value injected by FXMLLoader

    @FXML // fx:id="btVista"
    private JFXButton btVista; // Value injected by FXMLLoader

    //Minhas Variáveis
    private static int nTotalItem = 0;
    private int nItem;

    @FXML
    void click(ActionEvent event) {
        if (event.getSource() == btDel) {
            ItemControlador.nTotalItem--;
            ListaClienteControlador.deleta(this.nItem);
        } else if (event.getSource() == btVista) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nItem = ItemControlador.nTotalItem++;

        System.out.println(nItem);
    }
}
