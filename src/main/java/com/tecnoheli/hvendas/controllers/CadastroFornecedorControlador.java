/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXChipView;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.models.Produto;
import com.tecnoheli.hvendas.models.builder.FornecedorBuilder;
import com.tecnoheli.hvendas.models.dao.FornecedorDAO;
import com.tecnoheli.hvendas.models.dao.ProdutoDAO;
import com.tecnoheli.hvendas.models.property.ProdutoProperty;
import com.tecnoheli.hvendas.views.CadastroFornecedorView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroFornecedorControlador implements Initializable {

    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader

    @FXML // fx:id="tfNomeFornecedor"
    private JFXTextField tfNomeFornecedor; // Value injected by FXMLLoader

    @FXML // fx:id="tfNIF"
    private JFXTextField tfNIF; // Value injected by FXMLLoader

    @FXML // fx:id="cvProdutos"
    private JFXChipView<ProdutoProperty> cvProdutos; // Value injected by FXMLLoader

    @FXML // fx:id="btAd"
    private JFXButton btAd; // Value injected by FXMLLoader

    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    //Minhas Variáveis
    private ProdutoDAO daoProd;
    private FornecedorDAO dao;

    @FXML
    void adicionar(ActionEvent event) {

        final var fornecedor = FornecedorBuilder.novoFornecedor().comNome(tfNomeFornecedor.getText()).
                comNif(tfNIF.getText()).comProdutos(converteParaList(cvProdutos.getChips()))
                .build();

        dao.inserir(fornecedor);

        CadastroFornecedorView.setAberto(false);
        CadastroFornecedorView.getStage().close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        CadastroFornecedorView.setAberto(false);
        CadastroFornecedorView.getStage().close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apContainer.getStylesheets().clear();
        apContainer.getStylesheets().add(TelaPrincipalControlador.getEstilo());

        dao = new FornecedorDAO();
        daoProd = new ProdutoDAO();

        daoProd.listarTodos().forEach(produto -> cvProdutos.getSuggestions()
                .add(new ProdutoProperty(
                        produto.getCodigo(),
                        produto.getNome(),
                        .0,
                        .0,
                        0L))
        );

        ListChangeListener<ProdutoProperty> listener = change -> {
            if (change.wasAdded())
                cvProdutos.getSuggestions().removeAll(cvProdutos.getChips());
            else if (change.wasRemoved())
                cvProdutos.getSuggestions().addAll(change.getRemoved());
        };

        cvProdutos.getChips().addListener(listener);

    }

    private List<Produto> converteParaList(final ObservableList<ProdutoProperty> itens) {
        final List<Produto> produtos = new ArrayList<>();
        final var dao = new ProdutoDAO();

        for (ProdutoProperty item : itens) {
            final var produto = dao.recuperar(item.getCodigo());
            produtos.add(produto);
        }
        return produtos;
    }

}
