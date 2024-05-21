package com.orthofluent.orthofluent.controller;

import javafx.fxml.FXML;

public class CompteController extends BaseController{

    @FXML
    private void initialize() {
        consultationItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/Consultation.fxml",consultationItem));
        suiviItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/Suivi.fxml",suiviItem));
        atelierItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/Atelier.fxml",atelierItem));
        qcmItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/QCM.fxml",qcmItem));
        qcuItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/QCU.fxml",qcuItem));
        questionLibreItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/QuestLibres.fxml",questionLibreItem));
        anamneseEnfantItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/QuestAnamneseEnfant.fxml",anamneseEnfantItem));
        anamneseAdulteItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/QuestAnamneseAdulte.fxml",anamneseAdulteItem));
        patientEnfantItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/PatientEnfant.fxml",patientEnfantItem));
        patientAdulteItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/PatientAdulte.fxml",patientAdulteItem));
        compteItem.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/Compte.fxml",compteItem));
    }
}
