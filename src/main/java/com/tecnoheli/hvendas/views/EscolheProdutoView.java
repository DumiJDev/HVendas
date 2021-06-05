package com.tecnoheli.hvendas.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EscolheProdutoView extends Application {

    private static Stage stage;
    private static boolean aberto = false;

    public EscolheProdutoView() throws IOException {
        start(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        EscolheProdutoView.stage = stage;
    }

    public static boolean isAberto() {
        return aberto;
    }

    public static void setAberto(boolean aberto) {
        EscolheProdutoView.aberto = aberto;
    }

    @Override
    public void start(Stage estudio) throws IOException {
        final Parent parent = FXMLLoader.load(getClass().getResource("/fxml/escolheProduto.fxml"));

        Scene cenario = new Scene(parent);

        estudio.setScene(cenario);
        estudio.setResizable(false);
        estudio.setAlwaysOnTop(true);
        estudio.setTitle("Escolhe um produto");
        estudio.initModality(Modality.WINDOW_MODAL);

        estudio.setOnCloseRequest(windowEvent -> aberto = false);

        setStage(estudio);
        aberto = true;
        estudio.show();
    }
}
