package com.tecnoheli.hvendas.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroProdutoView extends Application {

    private static boolean aberto = false;
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isAberto() {
        return aberto;
    }

    public static void setAberto(boolean b) {
        aberto = b;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastroProdutoView.stage = stage;
    }

    @Override
    public void start(Stage estudio) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/cadastroProduto.fxml"));
        Scene cenario = new Scene(parent);
        estudio.setScene(cenario);
        estudio.setResizable(false);
        estudio.setTitle("Cadastro: Produto");
        estudio.setAlwaysOnTop(true);

        aberto = true;
        estudio.setOnCloseRequest(windowEvent -> aberto = false);

        setStage(estudio);
        estudio.show();
    }
}
