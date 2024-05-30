package com.orthofluent.orthofluent.controller.patient;


import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.PatientEnfant;
import com.orthofluent.orthofluent.models.enumerations.TypePatient;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDossierExistant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class PatientEnfantAjouterController extends AjoutModifierController {
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
    private TextField telephoneParentField;
    @FXML
    private TextField classEtudeField;


    @FXML
    private void initialize() {
        homeNavigation();
    }

    private void addPatientEnfant() throws ExceptionCreationImpossible{
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText();
        Date dateNaissance = Date.valueOf(dateNaissancePicker.getValue());
        String adresse = adresseField.getText();
        String telephone = telephoneField.getText();
        String telephoneParent = telephoneParentField.getText();
        String classEtude = classEtudeField.getText();
        PatientEnfant patientEnfant = new PatientEnfant(nom, Integer.parseInt(age),adresse,prenom, dateNaissance, telephone, TypePatient.ENFANT, telephoneParent, classEtude);
        try {
            DataManager.getInstance().getOrthophoniste().initialiserPatient(patientEnfant);
        } catch (ExceptionDossierExistant e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("Erreur lors de l'ajout du patient");
        }
    }
    @FXML
    private void handleConfirmerButton() {
        try {
            addPatientEnfant();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/PatientEnfant.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
