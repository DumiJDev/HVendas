package com.tecnoheli.hvendas.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CadastroFuncionarioView extends Application {

    private static boolean aberto = false;
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isAberto() {
        return aberto;
    }

    public static void setAberto(boolean aberto) {
        CadastroFuncionarioView.aberto = aberto;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastroFuncionarioView.stage = stage;
    }

    private static void handle(WindowEvent windowEvent) {
        aberto = false;
    }

    @Override
    public void start(Stage estudio) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/cadastroFuncionario.fxml"));
        Scene cenario = new Scene(parent);
        estudio.setScene(cenario);
        estudio.setResizable(false);
        estudio.setTitle("Cadastro: Funcionário");
        estudio.setAlwaysOnTop(true);

        aberto = true;
        estudio.setOnCloseRequest(CadastroFuncionarioView::handle);

        setStage(estudio);
        estudio.show();
    }
}
