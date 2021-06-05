package com.tecnoheli.hvendas.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tecnoheli.hvendas.exceptions.QuantidadeProdutoInvalidoException;
import com.tecnoheli.hvendas.exceptions.StockUltrapassadoException;
import com.tecnoheli.hvendas.models.Compra;
import com.tecnoheli.hvendas.models.Venda;
import com.tecnoheli.hvendas.models.dao.FornecedorDAO;
import com.tecnoheli.hvendas.models.dao.ProdutoDAO;
import com.tecnoheli.hvendas.models.property.ItemProperty;
import com.tecnoheli.hvendas.models.property.ProdutoProperty;
import com.tecnoheli.hvendas.views.EscolheProdutoView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EscolheProdutoControlador implements Initializable {

    //Minhas Variáveis
    private static int acao;
    private static String idFornecedor;
    private static String idCliente;


    @FXML // fx:id="apContainer"
    private AnchorPane apContainer; // Value injected by FXMLLoader
    @FXML // fx:id="tfQtd"
    private JFXTextField tfQtd; // Value injected by FXMLLoader
    @FXML // fx:id="cbProdutos"
    private JFXComboBox<ProdutoProperty> cbProdutos; // Value injected by FXMLLoader
    @FXML // fx:id="btConfirma"
    private JFXButton btConfirma; // Value injected by FXMLLoader

    public static void setAcao(int acao) {
        EscolheProdutoControlador.acao = acao;
    }

    public static void setIdFornecedor(String idFornecedor) {
        EscolheProdutoControlador.idFornecedor = idFornecedor;
    }

    public static void setIdCliente(String idCliente) {
        EscolheProdutoControlador.idCliente = idCliente;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apContainer.getStylesheets().clear();
        apContainer.getStylesheets().add(TelaPrincipalControlador.getEstilo());

        final var dao = new ProdutoDAO();
        final var daoF = new FornecedorDAO();

        final var produtos = dao.listarTodos();

        if (acao == 1) {
            produtos.removeIf(produto -> CadastroCompraControlador.getTableView().
                            getItems().contains(
                    new ItemProperty<Compra>(produto.getCodigo(), 0, "", 0)
                    )
            );
            if (daoF.existe(idFornecedor))
                produtos.addAll(daoF.recuperar(idFornecedor).getProdutos());
            else produtos.addAll(dao.listarTodos());
        } else if (acao == 2) {
            produtos.removeIf(produto -> CadastroVendaControlador.getTableView().
                            getItems().contains(
                    new ItemProperty<Venda>(produto.getCodigo(), 0, "", 0)
                    )
            );

            //produtos.addAll(new ProdutoDAO().listarTodos());
        }

        produtos.forEach(produto -> cbProdutos.getItems().add(
                new ProdutoProperty(
                        produto.getCodigo(),
                        produto.getNome(),
                        produto.getPrecoCompra(),
                        produto.getPrecoVenda(),
                        produto.getEstoque().getQuantidade()
                )
        ));


        btConfirma.setOnAction(event -> {

            final var item = cbProdutos.getSelectionModel().getSelectedItem();
            final var qtd = Long.parseLong(tfQtd.getText().replaceAll(",", ".").trim());

            if (qtd > 0) {

                if (item.getEstoque() >= qtd) {
                    if (acao == 1) {
                        CadastroCompraControlador.getTableView().
                                getItems().add(new ItemProperty<>(item.getCodigo(), qtd, item.getNome(), item.getPrecoCompra()));

                    } else if (acao == 2) {
                        System.out.println(item.getCodigo());
                        CadastroVendaControlador.getTableView().
                                getItems().add(new ItemProperty<>(item.getCodigo(), qtd, item.getNome(), item.getPrecoVenda()));
                    }
                } else try {
                    throw new StockUltrapassadoException("O valor a retirar é superior ao stock(" + item.getEstoque() + ')');
                } catch (StockUltrapassadoException e) {
                    e.printStackTrace();
                }
            } else try {
                throw new QuantidadeProdutoInvalidoException("Quantidade inválida!!!");
            } catch (QuantidadeProdutoInvalidoException e) {
                e.printStackTrace();
            }

            EscolheProdutoView.getStage().close();
            EscolheProdutoView.setAberto(false);
        });
    }
}
