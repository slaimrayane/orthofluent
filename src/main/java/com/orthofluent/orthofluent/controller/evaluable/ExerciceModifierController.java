package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.Exercise;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ExerciceModifierController extends AjoutModifierController {
    @FXML
    private TextField enonceTextField;
    @FXML
    private TextField noteTextField;
    @FXML
    private TextField materielTextField;

    Exercise exercise;

    @FXML
    public void initialize() {
        exercise =(Exercise) DataManager.getInstance().getExercise();
        enonceTextField.setText(exercise.getEnonce());
        noteTextField.setText(String.valueOf(exercise.getNote()));
        materielTextField.setText(exercise.getMateriel());
        homeNavigation();
    }

    private void UpdateExercice() {
        String enonce = enonceTextField.getText();
        int note = Integer.parseInt(noteTextField.getText());
        String materiel = materielTextField.getText();
        // Here you can add the code to add the exercice to the database
        DataManager.getInstance().getOrthophoniste().modifierExercice(exercise, enonce, note, materiel);
    }

    @FXML
    public void handleConfirmerButton() {
        try {
            UpdateExercice();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Exercices.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
