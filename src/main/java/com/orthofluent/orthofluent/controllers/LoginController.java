package com.orthofluent.orthofluent.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

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
            // La logique d'inscription ici
            System.out.println("Inscription réussie pour : " + nom + " " + prenom);
        } else {
            // Afficher un message d'erreur
            System.out.println("Les mots de passe ne correspondent pas !");
        }
    }
}
