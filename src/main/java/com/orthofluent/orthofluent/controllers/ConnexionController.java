package com.orthofluent.orthofluent.controllers;

import com.orthofluent.orthofluent.models.CabinetOrthophonique;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ConnexionController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button connexionButton;
    @FXML
    private void initialize() {
        // Initialisation, si nécessaire
    }
    @FXML
    private void HandleConnexion(){
            // Get the entered email and password
    String email = emailField.getText();
    String password = passwordField.getText();

    // Check if the entered email and password match a user in the system
    // This is a simple example and doesn't include actual authentication logic
    if (CabinetOrthophonique.getInstance().authentifier(email,password)) {
        System.out.println("Connexion réussie pour : " + email);
        // Load the home page
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Home.fxml"));
            Stage stage = (Stage) connexionButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        // Display an error message
        System.out.println("Les identifiants ne correspondent pas !");
    }
    }
}
