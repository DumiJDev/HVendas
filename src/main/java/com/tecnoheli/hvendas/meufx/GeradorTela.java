package com.tecnoheli.hvendas.meufx;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import javafx.scene.Parent;

public final class GeradorTela {

    public static final int LISTA_CLIENTE = 1;
    public static final int LISTA_COMPRA = 2;
    public static final int LISTA_ESTOQUE = 3;
    public static final int LISTA_FORNECEDOR = 4;
    public static final int LISTA_FUNCIONARIO = 5;
    public static final int LISTA_VENDA = 6;

    public static final int CADASTRO_COMPRA = 7;
    public static final int CADASTRO_ESTOQUE = 8;
    public static final int CADASTRO_FORNECEDOR = 9;
    public static final int CADASTRO_FUNCIONARIO = 10;
    public static final int CADASTRO_VENDA = 11;

    public static final int ATUALIZA_CLIENTE = 12;
    public static final int ATUALIZA_COMPRA = 13;
    public static final int ATUALIZA_ESTOQUE = 14;
    public static final int ATUALIZA_FORNECEDOR = 15;
    public static final int ATUALIZA_FUNCIONARIO = 16;
    public static final int ATUALIZA_VENDA = 17;

    public static final int DETALHES_CLIENTE = 18;
    public static final int DETALHES_COMPRA = 19;
    public static final int DETALHES_ESTOQUE = 20;
    public static final int DETALHES_FORNECEDOR = 21;
    public static final int DETALHES_FUNCIONARIO = 22;
    public static final int DETALHES_VENDA = 23;

    private final Map<Integer, Parent> telasListar;
    private final Map<Integer, Parent> telasCadastrar;
    private final Map<Integer, Parent> telasDetalhes;


    public GeradorTela() {
        final String[] lista = {
                "/fxml/listaCliente.fxml",
                "/fxml/listaCompra.fxml",
                "/fxml/listaProduto.fxml",
                "/fxml/listaFornecedor.fxml",
                "/fxml/listaFuncionario.fxml",
                "/fxml/listaVenda.fxml"
        };

        final String[] cadastro = {
                "/fxml/cadastroCompra.fxml",
                "/fxml/cadastroProduto.fxml",
                "/fxml/cadastroFornecedor.fxml",
                "/fxml/cadastroFuncionario.fxml",
                "/fxml/cadastroVenda.fxml"
        };

        final String[] detalhes = {
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
            if (indice < 5)
                telasCadastrar.put(indice + 7, carrega(cadastro[indice]));
            telasDetalhes.put(indice + 18, carrega(detalhes[indice]));
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
        return tela <= 23 && tela >= 18 ? telasDetalhes.get(tela) : null;
    }

    public Parent cadastro(int tela) {
        return tela <= 11 && tela >= 7 ? telasCadastrar.get(tela) : null;
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
