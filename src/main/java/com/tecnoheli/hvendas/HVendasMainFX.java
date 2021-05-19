package com.tecnoheli.hvendas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HVendasMainFX extends Application {

    private static Stage hVendasStage;

    public static Stage getHVendasStage() {
        return hVendasStage;
    }

    public static void setHVendasStage(Stage hVendasStage) {
        HVendasMainFX.hVendasStage = hVendasStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param estudio the primary stage for this application, onto which
     *                the application scene can be set. The primary stage will be embedded in
     *                the browser if the application was launched as an applet.
     *                Applications may create other stages, if needed, but they will not be
     *                primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage estudio) throws Exception {
        //Carregando e importando o fxml
        final Parent parent = FXMLLoader.load(getClass().getResource("/fxml/telaPrincipal2.fxml"));

        //Adicionando o parent ao cenario
        final Scene cenario = new Scene(parent);

        //Adicionando o cenario ao estudio
        estudio.setScene(cenario);

        //Definindo o título
        estudio.setTitle("HVendas: Sistema de gestão de compras e vendas");
        setHVendasStage(estudio);
        estudio.show();

    }

    /**
     * The application initialization method. This method is called immediately
     * after the Application class is loaded and constructed. An application may
     * override this method to perform initialization prior to the actual starting
     * of the application.
     *
     * <p>
     * The implementation of this method provided by the Application class does nothing.
     * </p>
     *
     * <p>
     * NOTE: This method is not called on the JavaFX Application Thread. An
     * application must not construct a Scene or a Stage in this
     * method.
     * An application may construct other JavaFX objects in this method.
     * </p>
     */
    @Override
    public void init() throws Exception {
        super.init();
    }

    /**
     * This method is called when the application should stop, and provides a
     * convenient place to prepare for application exit and destroy resources.
     *
     * <p>
     * The implementation of this method provided by the Application class does nothing.
     * </p>
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     */
    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
