/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.models.Compra;
import com.tecnoheli.hvendas.models.Fornecedor;
import com.tecnoheli.hvendas.models.Item;
import com.tecnoheli.hvendas.models.builder.CompraBuilder;
import com.tecnoheli.hvendas.models.builder.FornecedorBuilder;
import com.tecnoheli.hvendas.models.builder.ItemBuilder;
import com.tecnoheli.hvendas.models.dao.CompraDAO;
import com.tecnoheli.hvendas.models.dao.FornecedorDAO;
import com.tecnoheli.hvendas.models.dao.ItemDAO;
import com.tecnoheli.hvendas.models.dao.ProdutoDAO;
import com.tecnoheli.hvendas.models.property.FornecedorProperty;
import com.tecnoheli.hvendas.models.property.ItemProperty;
import com.tecnoheli.hvendas.util.Alerta;
import com.tecnoheli.hvendas.views.EscolheProdutoView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroCompraControlador implements Initializable {

    //Minhas Variáveis
    private static TableView<ItemProperty<Compra>> tableView;

    @FXML // fx:id="tvProdutos"
    private TableView<ItemProperty<Compra>> tvProdutos; // Value injected by FXMLLoader
    @FXML // fx:id="cvNome"
    private TableColumn<ItemProperty<Compra>, String> cvNome; // Value injected by FXMLLoader
    @FXML // fx:id="cvQuantidade"
    private TableColumn<ItemProperty<Compra>, Integer> cvQuantidade; // Value injected by FXMLLoader
    @FXML // fx:id="cbPreco"
    private TableColumn<ItemProperty<Compra>, Double> cbPreco; // Value injected by FXMLLoader
    @FXML // fx:id="ctTotal"
    private TableColumn<ItemProperty<Compra>, Double> ctTotal; // Value injected by FXMLLoader
    @FXML // fx:id="rbCasa"
    private JFXRadioButton rbCasa; // Value injected by FXMLLoader
    @FXML // fx:id="tgCliente"
    private ToggleGroup tgFornecedor; // Value injected by FXMLLoader
    @FXML // fx:id="rbNovo"
    private JFXRadioButton rbNovo; // Value injected by FXMLLoader
    @FXML // fx:id="cbFornecedores"
    private JFXComboBox<FornecedorProperty> cbFornecedores; // Value injected by FXMLLoader
    @FXML // fx:id="tfNome"
    private JFXTextField tfNome; // Value injected by FXMLLoader
    @FXML // fx:id="tfNIF"
    private JFXTextField tfNIF; // Value injected by FXMLLoader
    @FXML // fx:id="btAdProd"
    private JFXButton btAdProd; // Value injected by FXMLLoader
    @FXML // fx:id="btAtProd"
    private JFXButton btAtProd; // Value injected by FXMLLoader
    @FXML // fx:id="btLimpLista"
    private JFXButton btLimpLista; // Value injected by FXMLLoader
    @FXML // fx:id="btElProd"
    private JFXButton btElProd; // Value injected by FXMLLoader
    @FXML // fx:id="lbTotal"
    private Label lbTotal; // Value injected by FXMLLoader
    @FXML // fx:id="btConcluido"
    private JFXButton btConcluido; // Value injected by FXMLLoader
    @FXML // fx:id="btCancelar"
    private JFXButton btCancelar; // Value injected by FXMLLoader

    private CompraDAO dao;

    public static TableView<ItemProperty<Compra>> getTableView() {
        return tableView;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dao = new CompraDAO();

        final var daoF = new FornecedorDAO();

        daoF.listarTodos().forEach(fornecedor ->
                cbFornecedores.getItems().add(new FornecedorProperty(fornecedor.getNome(), fornecedor.getNif())));

        cvNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cbPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        ctTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        cvQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        rbNovo.setOnAction(event -> estadoRadio(true));
        rbCasa.setOnAction(event -> estadoRadio(false));

        btAdProd.setOnAction(event -> {
            if (rbCasa.isSelected()) {
                if (cbFornecedores.getSelectionModel().getSelectedItem() != null) {
                    if (!EscolheProdutoView.isAberto()) {
                        EscolheProdutoControlador.setAcao(1);
                        EscolheProdutoControlador.setIdFornecedor(cbFornecedores.
                                getSelectionModel().getSelectedItem().getNif());
                        try {
                            new EscolheProdutoView().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else Alerta.aviso("Escolhe um fornecedor!", "Fornecedor");
            } else {
                if (!EscolheProdutoView.isAberto()) {
                    EscolheProdutoControlador.setAcao(1);
                    EscolheProdutoControlador.setIdFornecedor("");
                    try {
                        var escolheProdutoView = new EscolheProdutoView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ListChangeListener<ItemProperty<Compra>> listener = change -> {
            double total = tvProdutos.getItems().stream().mapToDouble(ItemProperty::getTotal).sum();
            //NumberFormat nf = new DecimalFormat();
            lbTotal.setText(String.format("%.2f Akz", total));

            estadoBotao(change.getList().size() <= 0);
        };

        tvProdutos.getItems().addListener(listener);

        btLimpLista.setOnAction(event -> tvProdutos.getItems().clear());

        btElProd.setOnAction(event ->
                tvProdutos.getItems().removeAll(tvProdutos.getSelectionModel().getSelectedItems()));

        btConcluido.setOnAction(event -> {
            Fornecedor f = null;

            if (rbCasa.isSelected()) {
                if (cbFornecedores.getSelectionModel().getSelectedItem() != null)
                    f = daoF.recuperar(cbFornecedores.getSelectionModel().getSelectedItem().getNif());
                else Alerta.aviso("Fornecedor vazio!", "Fornecedor");
            } else if (rbNovo.isSelected()) {
                if (!"".equals(tfNIF.getText().trim()) && !"".equals(tfNome.getText())) {
                    f = FornecedorBuilder.novoFornecedor().comNome(tfNome.getText()).comNif(tfNIF.getText()).build();
                    f = daoF.inserir(f);
                } else Alerta.aviso("Nome ou NIF vazio!", "Fornecedor");
            }

            if (f != null) {
                if (!tvProdutos.getItems().isEmpty()) {
                    final var produtos = converteParaList(tvProdutos.getItems());
                    final var compra = CompraBuilder.novaCompra().
                            comDataCompra(LocalDateTime.now().plusHours(1)).
                            comFornecedor(f).comFuncionario(TelaPrincipalControlador.getFuncionario()).build();

                    produtos.forEach(produto -> produto.getProduto().getEstoque().aumenta(produto.getQuantidade()));

                    final var produtoDAO = new ProdutoDAO();

                    produtos.forEach(item -> item.setProduto(produtoDAO.alterar(item.getProduto())));

                    compra.setItens(new ItemDAO().inserirTodos(produtos));

                    if (rbNovo.isSelected()) {
                        f.setProdutos(produtos.stream().map(Item::getProduto).collect(Collectors.toList()));
                        daoF.alterar(f);
                    }

                    dao.inserir(compra);
                    Alerta.concluido("Compra realizada com sucesso!", "Compra");
                    cbFornecedores.getSelectionModel().clearSelection();
                    tvProdutos.getItems().clear();
                    tfNome.setText("");
                    tfNIF.setText("");
                } else {
                    Alerta.aviso("Itens vazio!", "Itens");
                }
            }
        });

        tableView = tvProdutos;
    }

    private List<Item> converteParaList(final ObservableList<ItemProperty<Compra>> itens) {
        final var produtos = new ArrayList<Item>();
        final var dao = new ProdutoDAO();

        for (ItemProperty<Compra> item : itens) {
            final var build = ItemBuilder.
                    novoItem().comQuantidade(item.getQuantidade()).
                    comProduto(dao.recuperar(item.getCodigo())).build();

            produtos.add(build);
        }

        return produtos;
    }

    private void estadoRadio(boolean estado) {
        cbFornecedores.setDisable(estado);
        tfNome.setDisable(!estado);
        tfNIF.setDisable(!estado);
    }

    private void estadoBotao(boolean estado) {
        btAtProd.setDisable(estado);
        btElProd.setDisable(estado);
        btLimpLista.setDisable(estado);
    }
}
