/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.models.builder.EstoqueBuilder;
import com.tecnoheli.hvendas.models.builder.ProdutoBuilder;
import com.tecnoheli.hvendas.models.dao.ProdutoDAO;
import com.tecnoheli.hvendas.views.CadastroProdutoView;
import javafx.application.Platform;
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
public class CadastroProdutoControlador implements Initializable {

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeProduto"
    private JFXTextField tfNomeProduto; // Value injected by FXMLLoader

    @FXML // fx:id="tfQtdStock"
    private JFXTextField tfQtdStock; // Value injected by FXMLLoader

    @FXML // fx:id="tfPrecoCompra"
    private JFXTextField tfPrecoCompra; // Value injected by FXMLLoader

    @FXML // fx:id="tfPrecoVenda"
    private JFXTextField tfPrecoVenda; // Value injected by FXMLLoader

    @FXML // fx:id="btAdicionar"
    private JFXButton btAdicionar; // Value injected by FXMLLoader

    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    //Minhas Variáveis
    private ProdutoDAO dao;

    @FXML
    void adicionar(ActionEvent event) {
        if (!"".equals(tfNomeProduto.getText()) && !"".equals(tfPrecoCompra.getText()) &&
                !"".equals(tfPrecoVenda.getText()) && !"".equals(tfQtdStock.getText())) {

            final var precoCompra = tfPrecoCompra.getText().replaceAll(",", ".").trim();
            final var precoVenda = tfPrecoVenda.getText().replaceAll(",", ".").trim();
            final var estoqueTxt = tfQtdStock.getText();
            final var estoque = EstoqueBuilder.novoEstoque().comQuantidade(Long.parseLong(estoqueTxt)).build();

            final var produto = ProdutoBuilder.novoProduto().
                    comNome(tfNomeProduto.getText()).
                    comEstoque(estoque).
                    comPrecoCompra(Double.valueOf(precoCompra)).
                    comPrecoVenda(Double.valueOf(precoVenda)).build();

            dao.inserir(produto);

            Platform.runLater(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            CadastroProdutoView.setAberto(false);
            CadastroProdutoView.getStage().close();
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        CadastroProdutoView.setAberto(false);
        CadastroProdutoView.getStage().close();
    }

    @FXML
    void valida(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apContainer.getStylesheets().clear();
        apContainer.getStylesheets().add(TelaPrincipalControlador.getEstilo());

        dao = new ProdutoDAO();
    }

}
