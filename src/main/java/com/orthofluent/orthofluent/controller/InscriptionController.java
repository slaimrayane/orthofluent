package com.orthofluent.orthofluent.controller;



import com.orthofluent.orthofluent.models.Orthophoniste;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCompteExistant;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    private Button inscriptionButton;

    @FXML
    private void initialize() {
        // Initialisation, si nécessaire
    }
    private void addOrthophoniste()throws ExceptionCreationImpossible{
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();
        String motDePasse = motDePasseField.getText();

        Orthophoniste orthophoniste = new Orthophoniste(nom,prenom,adresse,Integer.parseInt(telephone),email,motDePasse);
        try {
            createSerializedProfile(orthophoniste);
        }catch(ExceptionCompteExistant e){
            e.getMessage();
            throw new ExceptionCreationImpossible("creation de profile echoue");
        }
    }
    private void createSerializedProfile(Orthophoniste orthophoniste) throws ExceptionCompteExistant ,ExceptionCreationImpossible{
        File file = new File("./src/main/resources/com/orthofluent/orthofluent/UsersInformation/" + orthophoniste.getUsername() + ".ser");
        if (file.exists()) {
            throw new ExceptionCompteExistant("un profile ave ce nom d'utilisateur existe deja");
        } else {
            try (FileOutputStream fileOutputStream = new FileOutputStream("./src/main/resources/com/orthofluent/orthofluent/UsersInformation/" + orthophoniste.getUsername() + ".ser");

                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                // Write the user object to the file
                objectOutputStream.writeObject(orthophoniste);
                System.out.println("User profile serialized and saved to " + orthophoniste.getUsername() + ".ser");
            } catch (IOException e) {
                e.printStackTrace();
                throw new ExceptionCreationImpossible("creation de profile echoue");
            }
        }
    }
    @FXML
    private void handleInscription(){
        try{
            addOrthophoniste();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Connexion.fxml"));
            Stage stage = (Stage) inscriptionButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        }catch(ExceptionCreationImpossible e){
            e.getMessage();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    @FXML
//    private void handleInscription() {
//        // Récupérer les valeurs des champs
//        String nom = nomField.getText();
//        String prenom = prenomField.getText();
//        String adresse = adresseField.getText();
//        String email = emailField.getText();
//        String telephone = telephoneField.getText();
//        String motDePasse = motDePasseField.getText();
//        String confirmationMotDePasse = confirmationMotDePasseField.getText();
//
//        // Ajouter la logique pour l'inscription (ex: validation des champs, enregistrement dans une base de données, etc.)
//        if (motDePasse.equals(confirmationMotDePasse)) {
//            CabinetOrthophonique.getInstance().creerCompte(nom, prenom, adresse, Integer.parseInt(telephone), email, motDePasse);
//            CabinetOrthophonique.getInstance().afficherOrthophonistes();
//            System.out.println("Inscription réussie pour : " + nom + " " + prenom);
//                    // Load the home page
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Home.fxml"));
//
//                Stage stage = (Stage) inscriptionButton.getScene().getWindow();
//
//                stage.setScene(new Scene(root));
//
//            } catch (IOException e) {
//
//                e.printStackTrace();
//
//            }
//        } else {
//            // Afficher un message d'erreur
//            System.out.println("Les mots de passe ne correspondent pas !");
//        }
//    }
}
