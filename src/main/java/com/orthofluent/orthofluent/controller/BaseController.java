package com.orthofluent.orthofluent.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;

import java.io.IOException;

public class BaseController {
    //rendez vous componenet
    @FXML
    protected MenuItem consultationItem;
    @FXML
    protected MenuItem suiviItem;
    @FXML
    protected MenuItem atelierItem;
    //test component
    @FXML
    protected MenuItem qcmItem;
    @FXML
    protected MenuItem qcuItem;
    @FXML
    protected MenuItem questionLibreItem;
    @FXML
    protected MenuItem exerciseItem;
    @FXML
    protected MenuItem anamneseAdulteItem;
    @FXML
    protected MenuItem anamneseEnfantItem;
    //patient component
    @FXML
    protected MenuItem patientEnfantItem;
    @FXML
    protected MenuItem patientAdulteItem;
    //parametres component
    @FXML
    protected MenuItem compteItem;

    protected void navigateTo(String fxmlPath,MenuItem menuItem) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) menuItem.getParentPopup().getOwnerWindow().getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void navigateTo(String fxmlPath, ToggleButton toggleButton) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) toggleButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void navigateTo(String fxmlPath, Button button) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void homeNavigation(){
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
