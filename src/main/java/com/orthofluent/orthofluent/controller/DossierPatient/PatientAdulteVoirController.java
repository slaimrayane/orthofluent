package com.orthofluent.orthofluent.controller.DossierPatient;

import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.DossierPatient;
import com.orthofluent.orthofluent.models.PatientAdulte;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PatientAdulteVoirController extends BaseController {
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
    private TextField professionTextField;
    @FXML
    private TextField adresseTextField;
    @FXML
    private TextField diplomeTextField;

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
        PatientAdulte patientAdulte = (PatientAdulte) dossierPatient.getPatient();
        nomTextField.setText(patientAdulte.getNom());
        prenomTextField.setText(patientAdulte.getPrenom());
        ageTextField.setText(String.valueOf(patientAdulte.getAge()));
        dateNaissanceTextField.setText(patientAdulte.getDateNaissance().toString());
        telephoneTextField.setText(patientAdulte.getTelephone());
        professionTextField.setText(patientAdulte.getProfession());
        adresseTextField.setText(patientAdulte.getAddresse());
        diplomeTextField.setText(patientAdulte.getDiplome());
        numeroDossierTextField.setText(dossierPatient.getNumeroDossier());

        ListeFicheButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/Home.fxml",ListeFicheButton);});
        ListeBilanButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/VoirAnamnese.fxml",ListeBilanButton);});
        ListeRDVButton.setOnAction(event -> {navigateTo("/com/orthofluent/orthofluent/views/Home.fxml",ListeRDVButton);});
    }



}
