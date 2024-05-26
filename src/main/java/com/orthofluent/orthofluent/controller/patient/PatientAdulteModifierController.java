package com.orthofluent.orthofluent.controller.patient;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.PatientAdulte;
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

public class PatientAdulteModifierController extends AjoutModifierController {
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

    private PatientAdulte patientAdulte;

    @FXML
    public void initialize(){
        homeNavigation();
        patientAdulte = (PatientAdulte) DataManager.getInstance().getPatient();
        nomField.setText(patientAdulte.getNom());
        prenomField.setText(patientAdulte.getPrenom());
        ageField.setText(String.valueOf(patientAdulte.getAge()));
        dateNaissancePicker.setValue(patientAdulte.getDateNaissance().toLocalDate());
        adresseField.setText(patientAdulte.getAddresse());
        telephoneField.setText(patientAdulte.getTelephone());
        professionField.setText(patientAdulte.getProfession());
        diplomeField.setText(patientAdulte.getDiplome());
        telephoneSecondaireField.setText(patientAdulte.getTelephoneSecondaire());
    }
    private void updatePatientAdulte() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText();
        Date dateNaissance = Date.valueOf(dateNaissancePicker.getValue());
        String adresse = adresseField.getText();
        String telephone = telephoneField.getText();
        String profession = professionField.getText();
        String diplome = diplomeField.getText();
        String telephoneSecondaire = telephoneSecondaireField.getText();
        DataManager.getInstance().getOrthophoniste().modifierDossierPatient(patientAdulte,nom,prenom,Integer.parseInt(age),dateNaissance,adresse,telephone,profession,diplome,telephoneSecondaire);

    }

    @FXML
    private void handleConfirmeButton() {
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
