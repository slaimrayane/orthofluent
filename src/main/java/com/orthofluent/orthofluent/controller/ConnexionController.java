package com.orthofluent.orthofluent.controller;


import com.orthofluent.orthofluent.models.Orthophoniste;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ConnexionController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button connexionButton;
//    @FXML
//    private Label passwordErrorMessage;
//    @FXML
//    private Label usernameErrorMessage;

    @FXML
    private Label errorMessage;
    @FXML
    private void initialize() {
        // Initialisation, si nécessaire
    }
    @FXML
    private void HandleConnexion() {
        // Get the entered email and password
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String password = passwordField.getText();

        String username = nom + "_" + prenom;
        Orthophoniste orthophoniste = authentifier(username, password);
        if (orthophoniste != null) {
            // Set the Utilisateur in the DataManager
            DataManager.getInstance().setOrthophoniste(orthophoniste);

            // Load the next page
            loadNextPage();
        }
    }

    private Orthophoniste authentifier(String username,String password) {

            //creating the path to the user file
            String filename = "./src/main/resources/com/orthofluent/orthofluent/UsersInformation/"+ username + ".ser";
            File file = new File(filename);

            if (file.exists()) {
            System.out.println("File is found");
            Orthophoniste orthophoniste = null;
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                orthophoniste = (Orthophoniste) objectInputStream.readObject();
                String storedUsername = orthophoniste.getUsername();
                String storedPassword = orthophoniste.getMotDePasse();

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return orthophoniste;
                } else {
                    errorMessage.setText("Invalid password!");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            errorMessage.setText("User does no exist!");
            System.out.println("Working Directory: " + System.getProperty("user.dir"));
            System.out.println("File Path: " + file.getAbsolutePath());
            System.out.println("File is not found");
        }
        return null;

    }

    private void loadNextPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Home.fxml"));
            Stage stage = (Stage) connexionButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





//    // Check if the entered email and password match a user in the system
//    // This is a simple example and doesn't include actual authentication logic
//    if (CabinetOrthophonique.getInstance().authentifier(email,password)) {
//        System.out.println("Connexion réussie pour : " + email);
//        // Load the home page
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Home.fxml"));
//            Stage stage = (Stage) connexionButton.getScene().getWindow();
//            stage.setScene(new Scene(root));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    } else {
//        // Display an error message
//        System.out.println("Les identifiants ne correspondent pas !");
//    }
//    }
}
