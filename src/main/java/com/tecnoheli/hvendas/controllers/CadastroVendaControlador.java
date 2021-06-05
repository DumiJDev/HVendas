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
import com.tecnoheli.hvendas.models.Cliente;
import com.tecnoheli.hvendas.models.Item;
import com.tecnoheli.hvendas.models.Venda;
import com.tecnoheli.hvendas.models.builder.ClienteBuilder;
import com.tecnoheli.hvendas.models.builder.ItemBuilder;
import com.tecnoheli.hvendas.models.builder.VendaBuilder;
import com.tecnoheli.hvendas.models.dao.ClienteDAO;
import com.tecnoheli.hvendas.models.dao.ItemDAO;
import com.tecnoheli.hvendas.models.dao.ProdutoDAO;
import com.tecnoheli.hvendas.models.dao.VendaDAO;
import com.tecnoheli.hvendas.models.property.ClienteProperty;
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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Dumilde Paulo
 */
public class CadastroVendaControlador implements Initializable {

    //Minhas Variáveis
    private static TableView<ItemProperty<Venda>> tableView;

    @FXML // fx:id="tvProdutos"
    private TableView<ItemProperty<Venda>> tvProdutos; // Value injected by FXMLLoader
    @FXML // fx:id="cvNome"
    private TableColumn<ItemProperty<Venda>, String> cvNome; // Value injected by FXMLLoader
    @FXML // fx:id="cvQuantidade"
    private TableColumn<ItemProperty<Venda>, Integer> cvQuantidade; // Value injected by FXMLLoader
    @FXML // fx:id="cbPreco"
    private TableColumn<ItemProperty<Venda>, Double> cbPreco; // Value injected by FXMLLoader
    @FXML // fx:id="ctTotal"
    private TableColumn<ItemProperty<Venda>, Double> ctTotal; // Value injected by FXMLLoader
    @FXML // fx:id="rbCasa"
    private JFXRadioButton rbCasa; // Value injected by FXMLLoader
    @FXML // fx:id="tgCliente"
    private ToggleGroup tgCliente; // Value injected by FXMLLoader
    @FXML // fx:id="rbNovo"
    private JFXRadioButton rbNovo; // Value injected by FXMLLoader
    @FXML // fx:id="cbClientes"
    private JFXComboBox<ClienteProperty> cbClientes; // Value injected by FXMLLoader
    @FXML // fx:id="tfNome"
    private JFXTextField tfNome; // Value injected by FXMLLoader
    @FXML // fx:id="tfTelefone"
    private JFXTextField tfTelefone; // Value injected by FXMLLoader
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

    //Minhas Variáveis
    private VendaDAO dao;

    public static TableView<ItemProperty<Venda>> getTableView() {
        return tableView;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dao = new VendaDAO();
        ClienteDAO daoC = new ClienteDAO();

        cvNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cbPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        ctTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        cvQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        daoC.listarTodos().forEach(cliente ->
                cbClientes.getItems().add(new ClienteProperty(cliente.getNome(), cliente.getTelefone())));

        rbNovo.setOnAction(event -> estadoRadio(true));

        rbCasa.setOnAction(event -> estadoRadio(false));

        btAdProd.setOnAction(event -> {
            if (!EscolheProdutoView.isAberto()) {
                EscolheProdutoControlador.setAcao(2);
                EscolheProdutoControlador.setIdFornecedor("");
                try {
                    EscolheProdutoView escolheProdutoView = new EscolheProdutoView();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ListChangeListener<ItemProperty<Venda>> listener = change -> {
            double total = tvProdutos.getItems().stream().mapToDouble(ItemProperty::getTotal).sum();
            //NumberFormat nf = new DecimalFormat();
            lbTotal.setText(String.format("%.2f Akz", total));

            estadoBotao(change.getList().size() <= 0);
        };

        btLimpLista.setOnAction(event -> tvProdutos.getItems().clear());

        btElProd.setOnAction(event ->
                tvProdutos.getItems().removeAll(tvProdutos.getSelectionModel().getSelectedItems()));

        tvProdutos.getItems().addListener(listener);

        btConcluido.setOnAction(event -> {
            Cliente c = null;

            if (rbCasa.isSelected()) {
                if (cbClientes.getSelectionModel().getSelectedItem() != null)
                    c = daoC.recuperar(cbClientes.getSelectionModel().getSelectedItem().getTelefone());
                else Alerta.aviso("Cliente vazio!", "Cliente");
            } else if (rbNovo.isSelected()) {
                if (!"".equals(tfTelefone.getText().trim()) && !"".equals(tfNome.getText())) {
                    c = ClienteBuilder.novoCliente().comNome(tfNome.getText()).comTelefone(tfTelefone.getText()).build();
                    c = daoC.inserir(c);
                } else Alerta.aviso("Nome ou Telefone vazio(s)!", "Cliente");
            }

            if (c != null) {
                if (!tvProdutos.getItems().isEmpty()) {
                    final var produtos = converteParaList(tvProdutos.getItems());
                    final var venda = VendaBuilder.novaVenda().
                            comDataVenda(LocalDateTime.now().plusHours(1)).
                            comCliente(c).comFuncionario(TelaPrincipalControlador.getFuncionario()).build();

                    produtos.forEach(produto -> produto.getProduto().getEstoque().diminui(produto.getQuantidade()));

                    final var produtoDAO = new ProdutoDAO();

                    produtos.forEach(item -> produtoDAO.alterar(item.getProduto()));

                    venda.setItens(new ItemDAO().inserirTodos(produtos));

                    dao.inserir(venda);
                    Alerta.concluido("Venda realizada com sucesso!", "Venda");
                    cbClientes.getSelectionModel().clearSelection();
                    tvProdutos.getItems().clear();
                    tfNome.setText("");
                    tfTelefone.setText("");
                } else {
                    Alerta.aviso("Itens vazio!", "Itens");
                }
            }
        });

        tableView = tvProdutos;
    }

    private List<Item> converteParaList(ObservableList<ItemProperty<Venda>> itens) {
        final var produtos = new ArrayList<Item>();
        final var dao = new ProdutoDAO();

        for (ItemProperty<Venda> item : itens) {
            final Item build = ItemBuilder.
                    novoItem().comQuantidade(item.getQuantidade()).
                    comProduto(dao.recuperar(item.getCodigo())).build();

            produtos.add(build);
        }

        return produtos;
    }

    private void estadoRadio(boolean estado) {
        cbClientes.setDisable(estado);
        tfNome.setDisable(!estado);
        tfTelefone.setDisable(!estado);
    }

    private void estadoBotao(boolean estado) {
        btAtProd.setDisable(estado);
        btElProd.setDisable(estado);
        btLimpLista.setDisable(estado);
    }

}
