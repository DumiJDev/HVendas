/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.LoginApp;
import com.tecnoheli.hvendas.models.dao.UsuarioDAO;
import com.tecnoheli.hvendas.views.HVendasMainFX;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class LoginUsuarioControlador implements Initializable {

    @FXML // fx:id="tfLoginUsuario"
    private JFXTextField tfLoginUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="cbManterAtivo"
    private JFXCheckBox cbManterAtivo; // Value injected by FXMLLoader

    @FXML // fx:id="btLogin"
    private JFXButton btLogin; // Value injected by FXMLLoader

    @FXML // fx:id="btEsqueceu"
    private JFXButton btEsqueceu; // Value injected by FXMLLoader

    @FXML // fx:id="pfPalavraPasseUsuario"
    private JFXPasswordField pfPalavraPasseUsuario; // Value injected by FXMLLoader

    //Minhas Variáveis
    private UsuarioDAO dao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new UsuarioDAO();

        btLogin.setOnAction(event -> {
            final var login = tfLoginUsuario.getText();
            final var senha = pfPalavraPasseUsuario.getText();

            if (dao.existe(login)) {
                final var logado = dao.
                        recuperar(login, senha) != null;

                if (logado) {
                    Platform.runLater(() -> {
                        try {
                            Thread.sleep(1000);
                            TelaPrincipalControlador.setFuncionario(dao.recuperar(login, senha).getFuncionario());
                            new HVendasMainFX().start(new Stage());
                            LoginApp.getStage().close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }

}
