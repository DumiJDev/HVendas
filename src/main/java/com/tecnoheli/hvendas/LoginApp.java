package com.tecnoheli.hvendas;

import com.tecnoheli.hvendas.util.jpa.JPAUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApp extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        LoginApp.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage estudio) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/loginUsuario.fxml"));

        Scene cenario = new Scene(parent);

        estudio.setScene(cenario);
        estudio.setTitle("Login: HVendas");
        estudio.setResizable(false);

        setStage(estudio);
        estudio.show();
    }

    @Override
    public void init() throws Exception {
        JPAUtil.abreConexao().close();
        super.init();
    }

    @Override
    public void stop() throws Exception {
        JPAUtil.fechaFabricaDeConexao();
        super.stop();
    }
}
