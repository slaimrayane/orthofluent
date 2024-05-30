package com.orthofluent.orthofluent.controller.rendezvous;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDateInvalide;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDatePrise;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConsultationAjouterController extends AjoutModifierController {
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private TextField ageTextField;

    @FXML
    private RadioButton adulteRadio;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField heureTextField;

    @FXML
    private Button confirmerButton;
    @FXML
    private void initialize(){
        homeNavigation();
    }
        private void ajouterConsultation() throws ExceptionCreationImpossible {
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String age = ageTextField.getText();
        boolean isAdulte = adulteRadio.isSelected();
        LocalDateTime date = LocalDateTime.of(datePicker.getValue(), LocalTime.MIN);
        String heureString = heureTextField.getText();
        LocalTime heure = LocalTime.parse(heureString);
        try {
            if (isAdulte){
                DataManager.getInstance().getOrthophoniste().programmerConsultationAdulte(date, heure, nom, prenom, age);
            } else {
                DataManager.getInstance().getOrthophoniste().programmerConsultationEnfant(date, heure, nom, prenom, age);
            }
        } catch (ExceptionDateInvalide e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("creation RDV impossible");
        } catch (ExceptionDatePrise e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("creation RDV impossible");
        }
    }

    @FXML
    protected void HandleConfirmerButton() {
        try {
            ajouterConsultation();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Consultation.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
