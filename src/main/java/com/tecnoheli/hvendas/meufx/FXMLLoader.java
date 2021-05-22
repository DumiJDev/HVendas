package com.tecnoheli.hvendas.meufx;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public final class FXMLLoader {

    public static final int LISTA_CLIENTE = 1;
    public static final int LISTA_COMPRA = 2;
    public static final int LISTA_ESTOQUE = 3;
    public static final int LISTA_FORNECEDOR = 4;
    public static final int LISTA_FUNCIONARIO = 5;
    public static final int LISTA_VENDA = 6;

    public static final int CADASTRO_CLIENTE = 7;
    public static final int CADASTRO_COMPRA = 8;
    public static final int CADASTRO_ESTOQUE = 9;
    public static final int CADASTRO_FORNECEDOR = 10;
    public static final int CADASTRO_FUNCIONARIO = 11;
    public static final int CADASTRO_VENDA = 12;

    public static final int ATUALIZA_CLIENTE = 13;
    public static final int ATUALIZA_COMPRA = 14;
    public static final int ATUALIZA_ESTOQUE = 15;
    public static final int ATUALIZA_FORNECEDOR = 16;
    public static final int ATUALIZA_FUNCIONARIO = 17;
    public static final int ATUALIZA_VENDA = 18;

    public static final int DETALHES_CLIENTE = 19;
    public static final int DETALHES_COMPRA = 20;
    public static final int DETALHES_ESTOQUE = 21;
    public static final int DETALHES_FORNECEDOR = 22;
    public static final int DETALHES_FUNCIONARIO = 23;
    public static final int DETALHES_VENDA = 24;

    private final Map<Integer, Parent> telasListar;
    private final Map<Integer, Parent> telasCadastrar;
    private final Map<Integer, Parent> telasDetalhes;


    public FXMLLoader() {
        final var lista = new String[]{
                "/fxml/listaCliente.fxml",
                "/fxml/listaCompra.fxml",
                "/fxml/listaProduto.fxml",
                "/fxml/listaFornecedor.fxml",
                "/fxml/listaFuncionario.fxml",
                "/fxml/listaVenda.fxml"
        };

        final var cadastro = new String[]{
                "/fxml/cadastroCliente.fxml",
                "/fxml/cadastroCompra.fxml",
                "/fxml/cadastroProduto.fxml",
                "/fxml/cadastroFornecedor.fxml",
                "/fxml/cadastroFuncionario.fxml",
                "/fxml/cadastroVenda.fxml"
        };

        final var detalhes = new String[]{
                "/fxml/detalhesCliente.fxml",
                "/fxml/detalhesCompra.fxml",
                "/fxml/detalhesProduto.fxml",
                "/fxml/detalhesFornecedor.fxml",
                "/fxml/detalhesFuncionario.fxml",
                "/fxml/detalhesVenda.fxml"
        };

        telasListar = new HashMap<>();
        telasCadastrar = new HashMap<>();
        telasDetalhes = new HashMap<>();

        IntStream.range(0, lista.length).forEach(indice -> {
            telasListar.put(indice + 1, carrega(lista[indice]));
            telasCadastrar.put(indice + 1, carrega(cadastro[indice]));
            telasDetalhes.put(indice + 1, carrega(detalhes[indice]));
        });
    }

    public Parent carrega(String fxml) {
        Parent parent = null;
        try {
            parent = javafx.fxml.FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parent;
    }

    public Parent lista(int tela) {
        return tela <= 6 && tela >= 1 ? telasListar.get(tela) : null;
    }

    public Parent detalhes(int tela) {
        return tela <= 24 && tela >= 19 ? telasDetalhes.get(tela) : null;
    }

    public Parent cadastro(int tela) {
        return tela <= 12 && tela >= 7 ? telasCadastrar.get(tela) : null;
    }

    public Collection<Parent> getTelasCadastrar() {
        return telasCadastrar.values();
    }

    public Collection<Parent> getTelasListar() {
        return telasListar.values();
    }

    public Collection<Parent> getTelasDetalhes() {
        return telasDetalhes.values();
    }

    public Parent item() {
        return carrega("/fxml/item.fxml");
    }
}
