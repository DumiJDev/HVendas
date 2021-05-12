package com.tecnoheli.hvendas.meufx;

import javafx.scene.Parent;

import java.io.IOException;

public final class FXMLLoader {

    public static Parent carrega(String fxml) throws IOException {
        return (Parent) javafx.fxml.FXMLLoader.load(FXMLLoader.class.getResource("/fxml/" + fxml + ".fxml"));
    }

}
