package com.tecnoheli.hvendas.util.meufx;

import javafx.scene.Parent;

import java.io.IOException;

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

    public static final int DETALHES_CLIENTE = 12;
    public static final int DETALHES_COMPRA = 13;
    public static final int DETALHES_ESTOQUE = 14;
    public static final int DETALHES_FORNECEDOR = 15;
    public static final int DETALHES_FUNCIONARIO = 16;
    public static final int DETALHES_VENDA = 17;

    private final String[] lista;


    public GeradorTela() {
        lista = new String[]{
                "/fxml/listaCliente.fxml",
                "/fxml/listaCompra.fxml",
                "/fxml/listaProduto.fxml",
                "/fxml/listaFornecedor.fxml",
                "/fxml/listaFuncionario.fxml",
                "/fxml/listaVenda.fxml",
                "/fxml/cadastroCompra.fxml",
                "/fxml/telaDeEspera.fxml",
                "/fxml/telaDeEspera.fxml",
                "/fxml/telaDeEspera.fxml",
                "/fxml/cadastroVenda.fxml",
                "/fxml/detalhesCliente.fxml",
                "/fxml/detalhesCompra.fxml",
                "/fxml/detalhesProduto.fxml",
                "/fxml/detalhesFornecedor.fxml",
                "/fxml/detalhesFuncionario.fxml",
                "/fxml/detalhesVenda.fxml"
        };

    }

    private Parent carrega(String fxml) {
        Parent parent = null;
        try {
            parent = javafx.fxml.FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parent;
    }

    public Parent lista(int tela) {
        return tela <= 6 && tela >= 1 ? carrega(lista[tela - 1]) : null;
    }

    public Parent detalhes(int tela) {
        return tela <= 17 && tela >= 12 ? carrega(lista[tela - 1]) : null;
    }

    public Parent cadastro(int tela) {
        return tela <= 11 && tela >= 7 ? carrega(lista[tela - 1]) : null;
    }
}
