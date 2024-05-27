package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.Exercise;

import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionEvaluableExistant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ExerciceAjouterController extends AjoutModifierController {
    @FXML
    private TextField enonceTextField;
    @FXML
    private TextField noteTextField;
    @FXML
    private TextField materielTextField;

    @FXML
    public void initialize() {
        homeNavigation();
    }

    private void addExercice() throws ExceptionCreationImpossible {
        String enonce = enonceTextField.getText();
        int note = Integer.parseInt(noteTextField.getText());
        String materiel = materielTextField.getText();
        // Here you can add the code to add the exercice to the database
        Exercise exercise = new Exercise(enonce, note, materiel);
        try {
            DataManager.getInstance().getOrthophoniste().ajouterExercice(exercise);
        } catch (ExceptionEvaluableExistant e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("L'exercice existe déjà");
        }
    }

    @FXML
    public void handleConfirmerButton() {
        try {
            addExercice();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/Exercices.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
