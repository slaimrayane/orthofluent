package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.Proposition;
import com.orthofluent.orthofluent.models.QCM;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QCMModifierController extends AjoutModifierController {
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

    QCM qcm;

    @FXML
    private void initialize() {
        homeNavigation();
        qcm = (QCM) DataManager.getInstance().getQuestion();
        questionField.setText(qcm.getEnonce());
        // Check the length of the propositions and set the text fields and checkboxes accordingly
        setPropositionFieldAndCheckBox(proposition1Field, proposition1CheckBox, 0);
        setPropositionFieldAndCheckBox(proposition2Field, proposition2CheckBox, 1);
        setPropositionFieldAndCheckBox(proposition3Field, proposition3CheckBox, 2);


    }
    private void setPropositionFieldAndCheckBox(TextField propositionField, CheckBox propositionCheckBox, int index) {
        if (qcm.getPropositionsList().size() > index) {
            String proposition = qcm.getPropositionsList().get(index).toString();
            if (proposition.length() > 0) {
                propositionField.setText(proposition);
                propositionCheckBox.setSelected(true);
            } else {
                propositionField.setText("");
                propositionCheckBox.setSelected(false);
            }
        } else {
            propositionField.setText("");
            propositionCheckBox.setSelected(false);
        }
    }
    private void updateQCM() {
        String question = questionField.getText();
        String proposition1 = proposition1Field.getText();
        String proposition2 = proposition2Field.getText();
        String proposition3 = proposition3Field.getText();
        boolean proposition1Ajout = proposition1CheckBox.isSelected();
        boolean proposition2Ajout = proposition2CheckBox.isSelected();
        boolean proposition3Ajout = proposition3CheckBox.isSelected();
        List<Proposition> propositions = new ArrayList<>();

        if(proposition1Ajout){
           propositions.add(new Proposition(proposition1));
        }
        if(proposition2Ajout){
            propositions.add(new Proposition(proposition2));
        }
        if(proposition3Ajout){
            propositions.add(new Proposition(proposition3));
        }
        DataManager.getInstance().getOrthophoniste().modifierQuestion(qcm, question, propositions);
    }
    @FXML
    private void handleConfirmerButton() {
        try {
            updateQCM();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QCM.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
