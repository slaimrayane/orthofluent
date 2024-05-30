package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.QuestionLibre;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestionLibreModifierController extends AjoutModifierController {
    @FXML
    private TextField enonceTextField;
    @FXML
    private TextField noteTextField;

    QuestionLibre questionLibre;

    @FXML
    public void initialize() {
        questionLibre =(QuestionLibre) DataManager.getInstance().getQuestion();
        enonceTextField.setText(questionLibre.getEnonce());
        noteTextField.setText(String.valueOf(questionLibre.getNote()));
        homeNavigation();
    }

    private void updateQuestionLibre() {
        String enonce = enonceTextField.getText();
        int note = Integer.parseInt(noteTextField.getText());
        DataManager.getInstance().getOrthophoniste().modifierQuestion(questionLibre, enonce, note);
    }
    @FXML
    public void handleConfirmerButton() {
        try {
            updateQuestionLibre();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QuestLibres.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
