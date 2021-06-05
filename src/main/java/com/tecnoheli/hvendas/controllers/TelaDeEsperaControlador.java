package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXSpinner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaDeEsperaControlador implements Initializable {

    //Minhas Variáveis
    private static Label mensagem;
    private static HBox container;
    @FXML // fx:id="hbContainer"
    private HBox hbContainer; // Value injected by FXMLLoader
    @FXML // fx:id="jfxs"
    private JFXSpinner jfxs; // Value injected by FXMLLoader
    @FXML // fx:id="lbMensagem"
    private Label lbMensagem; // Value injected by FXMLLoader

    public static void setMensagem(final String mensagem) {
        TelaDeEsperaControlador.mensagem.setText(mensagem);
    }

    public static HBox container() {
        return container;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mensagem = lbMensagem;
        container = hbContainer;
    }
}
