package com.orthofluent.orthofluent.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

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
}
