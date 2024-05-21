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

public class InscriptionController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField adresseField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telephoneField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private PasswordField confirmationMotDePasseField;

    @FXML
    private Button inscriptionButton;

    @FXML
    private void initialize() {
        // Initialisation, si nécessaire
    }

    @FXML
    private void handleInscription() {
        // Récupérer les valeurs des champs
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();
        String motDePasse = motDePasseField.getText();
        String confirmationMotDePasse = confirmationMotDePasseField.getText();

        // Ajouter la logique pour l'inscription (ex: validation des champs, enregistrement dans une base de données, etc.)
        if (motDePasse.equals(confirmationMotDePasse)) {
            CabinetOrthophonique.getInstance().creerCompte(nom, prenom, adresse, Integer.parseInt(telephone), email, motDePasse);
            CabinetOrthophonique.getInstance().afficherOrthophonistes();
            System.out.println("Inscription réussie pour : " + nom + " " + prenom);
                    // Load the home page
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Home.fxml"));

                Stage stage = (Stage) inscriptionButton.getScene().getWindow();

                stage.setScene(new Scene(root));

            } catch (IOException e) {

                e.printStackTrace();

            }
        } else {
            // Afficher un message d'erreur
            System.out.println("Les mots de passe ne correspondent pas !");
        }
    }
}
