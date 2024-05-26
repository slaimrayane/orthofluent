package com.orthofluent.orthofluent.controller.patient;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.PatientAdulte;
import com.orthofluent.orthofluent.models.enumerations.TypePatient;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDossierExistant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class PatientAdulteAjouterController extends AjoutModifierController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField ageField;
    @FXML
    private DatePicker dateNaissancePicker;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField professionField;
    @FXML
    private TextField diplomeField;
    @FXML
    private TextField telephoneSecondaireField;

    @FXML
    private Button confirmeButton;

    @FXML
    private void initialize() {
        homeNavigation();
    }

    private void addPatientAdulte() throws ExceptionCreationImpossible {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText();
        Date dateNaissance = Date.valueOf(dateNaissancePicker.getValue());
        String adresse = adresseField.getText();
        String telephone = telephoneField.getText();
        String profession = professionField.getText();
        String diplome = diplomeField.getText();
        String telephoneSecondaire = telephoneSecondaireField.getText();
        PatientAdulte patientAdulte = new PatientAdulte(nom, Integer.parseInt(age),adresse,prenom, dateNaissance, telephone, TypePatient.ADULTE, profession, diplome,telephoneSecondaire);
        try {
            DataManager.getInstance().getOrthophoniste().initialiserPatient(patientAdulte);
        } catch (ExceptionDossierExistant e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("Erreur lors de l'ajout du patient");
        }
    }
    @FXML
    private void handleConfirmeButton() {
        try {
            addPatientAdulte();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/PatientAdulte.fxml"));
            Stage stage = (Stage) confirmeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
