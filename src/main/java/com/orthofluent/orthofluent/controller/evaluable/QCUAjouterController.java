package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.Proposition;
import com.orthofluent.orthofluent.models.QCU;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionQuestionExistante;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class QCUAjouterController extends AjoutModifierController {
    @FXML
    private TextField questionField;
    @FXML
    private TextField proposition1Field;
    @FXML
    private TextField proposition2Field;
    @FXML
    private TextField proposition3Field;
    @FXML
    private CheckBox proposition1CheckBox;
    @FXML
    private CheckBox proposition2CheckBox;
    @FXML
    private CheckBox proposition3CheckBox;

    @FXML
    private void initialize() {
        homeNavigation();

    }
    private void addQCU() throws ExceptionCreationImpossible {
        String question = questionField.getText();
        String proposition1 = proposition1Field.getText();
        String proposition2 = proposition2Field.getText();
        String proposition3 = proposition3Field.getText();
        boolean proposition1Ajout = proposition1CheckBox.isSelected();
        boolean proposition2Ajout = proposition2CheckBox.isSelected();
        boolean proposition3Ajout = proposition3CheckBox.isSelected();
        QCU qcu = new QCU();
        qcu.setEnonce(question);
        if(proposition1Ajout){
            qcu.ajouterProposition(new Proposition( proposition1));
        }
        if(proposition2Ajout){
            qcu.ajouterProposition(new Proposition(proposition2));
        }
        if(proposition3Ajout){
            qcu.ajouterProposition(new Proposition(proposition3));
        }
        try {
            DataManager.getInstance().getOrthophoniste().ajouterQuestion(qcu);
        } catch (ExceptionQuestionExistante e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("La question existe déjà");
        }
    }
    @FXML
    private void handleConfirmerButton() {
        try {
            addQCU();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QCMList.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
