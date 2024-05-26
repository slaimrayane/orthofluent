package com.orthofluent.orthofluent.controller.patient;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.PatientEnfant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class PatientEnfantModifierController extends AjoutModifierController {
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

    private PatientEnfant patientEnfant;

    @FXML
    public void initialize(){
        homeNavigation();
        patientEnfant = (PatientEnfant) DataManager.getInstance().getPatient();

        nomField.setText(patientEnfant.getNom());
        prenomField.setText(patientEnfant.getPrenom());
        ageField.setText(String.valueOf(patientEnfant.getAge()));
        dateNaissancePicker.setValue(patientEnfant.getDateNaissance().toLocalDate());
        adresseField.setText(patientEnfant.getAddresse());
        telephoneField.setText(patientEnfant.getTelephone());
        telephoneParentField.setText(patientEnfant.getTelephoneparent());
        classEtudeField.setText(patientEnfant.getClassEtude());
    }

        private void updatePatientAdulte() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText();
        Date dateNaissance = Date.valueOf(dateNaissancePicker.getValue());
        String adresse = adresseField.getText();
        String telephone = telephoneField.getText();
        String telephoneParent = telephoneParentField.getText();
        String classEtude = classEtudeField.getText();
        DataManager.getInstance().getOrthophoniste().modifierDossierPatient(patientEnfant,nom,prenom,Integer.parseInt(age),dateNaissance,adresse,telephone,telephoneParent,classEtude);

    }

    @FXML
    private void handleConfirmerButton() {
        try {
            updatePatientAdulte();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/PatientAdulte.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
