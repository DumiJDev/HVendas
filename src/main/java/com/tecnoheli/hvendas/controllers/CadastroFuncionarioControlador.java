/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.*;
import com.tecnoheli.hvendas.models.Funcao;
import com.tecnoheli.hvendas.models.Sexo;
import com.tecnoheli.hvendas.models.Tipo;
import com.tecnoheli.hvendas.models.builder.BIBuilder;
import com.tecnoheli.hvendas.models.builder.FuncionarioBuilder;
import com.tecnoheli.hvendas.models.builder.UsuarioBuilder;
import com.tecnoheli.hvendas.models.dao.FuncionarioDAO;
import com.tecnoheli.hvendas.models.dao.UsuarioDAO;
import com.tecnoheli.hvendas.views.CadastroFuncionarioView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroFuncionarioControlador implements Initializable {

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeFuncionario"
    private JFXTextField tfNomeFuncionario; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomePai"
    private JFXTextField tfNomePai; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeMae"
    private JFXTextField tfNomeMae; // Value injected by FXMLLoader

    @FXML // fx:id="tfResidencia"
    private JFXTextField tfResidencia; // Value injected by FXMLLoader

    @FXML // fx:id="cbSexo"
    private JFXComboBox<Sexo> cbSexo; // Value injected by FXMLLoader

    @FXML // fx:id="tfNBI"
    private JFXTextField tfNBI; // Value injected by FXMLLoader

    @FXML // fx:id="dpDataNascimento"
    private JFXDatePicker dpDataNascimento; // Value injected by FXMLLoader

    @FXML // fx:id="cbCargo"
    private JFXComboBox<Funcao> cbCargo; // Value injected by FXMLLoader

    @FXML // fx:id="tfUsername"
    private JFXTextField tfUsername; // Value injected by FXMLLoader

    @FXML // fx:id="pfSenha"
    private JFXPasswordField pfSenha; // Value injected by FXMLLoader

    @FXML // fx:id="btAd"
    private JFXButton btAd; // Value injected by FXMLLoader

    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    //Minhas Variáveis
    private FuncionarioDAO dao;
    private UsuarioDAO daoU;

    @FXML
    void adicionar(ActionEvent event) {
        final var bi = BIBuilder.novoBI().comNome(tfNomeFuncionario.getText()).
                comNomeDoPai(tfNomePai.getText()).
                comNomeDaMae(tfNomeMae.getText()).
                comNumero(tfNBI.getText()).
                comSexo(cbSexo.getSelectionModel().getSelectedItem()).
                comResidencia(tfResidencia.getText()).
                comDataDeNascimento(dpDataNascimento.getValue()).build();

        final var funcionario = FuncionarioBuilder.novoFuncionario().
                comBi(bi).
                comFuncao(cbCargo.getSelectionModel().getSelectedItem()).
                comSalario(.0).
                build();

        final var funcionarioInserido = dao.inserir(funcionario);

        var tipo = daoU.conta() == 0 ? Tipo.ADMIN : Tipo.USER;

        final var usuario = UsuarioBuilder.novoUsuario().comTipo(tipo).
                comFuncionario(funcionarioInserido).
                comLogin(tfUsername.getText()).comSenha(pfSenha.getText()).build();

        daoU.inserir(usuario);

        CadastroFuncionarioView.setAberto(false);
        CadastroFuncionarioView.getStage().close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        CadastroFuncionarioView.setAberto(false);
        CadastroFuncionarioView.getStage().close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apContainer.getStylesheets().clear();
        apContainer.getStylesheets().add(TelaPrincipalControlador.getEstilo());

        cbCargo.getItems().addAll(Funcao.values());
        cbSexo.getItems().addAll(Sexo.values());

        dao = new FuncionarioDAO();
        daoU = new UsuarioDAO();
    }

}
