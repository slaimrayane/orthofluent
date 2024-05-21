package com.orthofluent.orthofluent.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class LandingPageController {
    @FXML
    private Button connexionButton;
    @FXML
    private Button inscriptionButton;

    @FXML
    private void initialize() {
        // Initialisation, si nécessaire
    }
    @FXML
    public void inscription() {
        System.out.println("bouton inscription clicke");

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Inscription.fxml"));
            Stage stage = (Stage) inscriptionButton.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @FXML
    public void connexion() {
        System.out.println("bouton connexion clicke");

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Connexion.fxml"));
            Stage stage = (Stage) inscriptionButton.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
