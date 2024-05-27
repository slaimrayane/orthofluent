package com.orthofluent.orthofluent.controller.DossierPatient;

import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.DossierPatient;

import com.orthofluent.orthofluent.models.PatientEnfant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PatientEnfantVoirController extends BaseController {
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private TextField dateNaissanceTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField telephoneTextField;
    @FXML
    private TextField telephoneParentTextField;

    @FXML
    private TextField classeEtudeTextField;

    @FXML
    private TextField numeroDossierTextField;

    @FXML
    private Button ListeBilanButton;

    @FXML
    private Button ListeFicheButton;
    @FXML
    private Button ListeRDVButton;

    private DossierPatient dossierPatient;

    @FXML
    public void initialize() {
        dossierPatient = DataManager.getInstance().getDossierPatient();
        PatientEnfant patientEnfant = (PatientEnfant) dossierPatient.getPatient();
        nomTextField.setText(patientEnfant.getNom());
        prenomTextField.setText(patientEnfant.getPrenom());
        ageTextField.setText(String.valueOf(patientEnfant.getAge()));
        dateNaissanceTextField.setText(patientEnfant.getDateNaissance().toString());
        telephoneTextField.setText(patientEnfant.getTelephone());
        telephoneParentTextField.setText(patientEnfant.getTelephoneparent());
        classeEtudeTextField.setText(patientEnfant.getClassEtude());
        numeroDossierTextField.setText(dossierPatient.getNumeroDossier());

        ListeFicheButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/Home.fxml",ListeFicheButton);});
        ListeBilanButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/VoirAnamnese.fxml",ListeBilanButton);});
        ListeRDVButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/Home.fxml",ListeRDVButton);});
    }


}
