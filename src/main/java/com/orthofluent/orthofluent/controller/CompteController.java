package com.orthofluent.orthofluent.controller;

import com.orthofluent.orthofluent.models.Orthophoniste;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CompteController extends BaseController{
    Orthophoniste orthophoniste;
    @FXML
    private TextField ancienMotDePasseTextField;
    @FXML
    private TextField nouveauMotDePasseTextField;

    @FXML
    private TextField ancienEmailTextField;
    @FXML
    private TextField nouveauEmailTextField;
    @FXML
    private TextField ancienTelephoneTextField;
    @FXML
    private TextField nouveauTelephoneTextField;
    @FXML
    private TextField ancienAdresseTextField;
    @FXML
    private TextField nouveauAdresseTextField;

    @FXML
    private Button modifierButton;

    @FXML
    private void initialize() {
        orthophoniste = DataManager.getInstance().getOrthophoniste();
        ancienAdresseTextField.setText(orthophoniste.getAdresse());
        ancienEmailTextField.setText(orthophoniste.getAdresseMail());
        ancienTelephoneTextField.setText(String.valueOf(orthophoniste.getNumTel()));
        ancienMotDePasseTextField.setText(orthophoniste.getMotDePasse());
        homeNavigation();
    }
    @FXML
    public void handleConfirmationButton(){
         try {
             updateOrthophoniste();
             Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/PatientEnfant.fxml"));
             Stage stage = (Stage) modifierButton.getScene().getWindow();
             stage.setScene(new Scene(root));
         } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void updateOrthophoniste(){
        String nouveauMotDePasse = nouveauMotDePasseTextField.getText();
        String nouveauEmail = nouveauEmailTextField.getText();
        String nouveauTelephone = nouveauTelephoneTextField.getText();
        String nouveauAdresse = nouveauAdresseTextField.getText();
        orthophoniste.setAdresse(nouveauAdresse);
        orthophoniste.setAdresseMail(nouveauEmail);
        orthophoniste.setNumTel(Integer.parseInt(nouveauTelephone));
        orthophoniste.setMotDePasse(nouveauMotDePasse);
    }
}
