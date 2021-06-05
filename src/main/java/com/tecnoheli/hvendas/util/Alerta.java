package com.tecnoheli.hvendas.util;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public final class Alerta {
    public static void aviso(String mensagem, String titulo) {
        final var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    public static void erro(String mensagem, String titulo) {
        final var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    public static void concluido(String mensagem, String titulo) {
        final var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    public static void informacao(String mensagem, String titulo) {
        final var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setHeaderText(mensagem);
        alert.show();
    }
}
