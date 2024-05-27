package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.QuestionLibre;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionQuestionExistante;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestionLibreAjouterController extends AjoutModifierController {
    @FXML
    private TextField enonceTextField;
    @FXML
    private TextField noteTextField;

    @FXML
    public void initialize() {
        homeNavigation();
    }

    private void addQuestionLibre() throws ExceptionCreationImpossible {
        String enonce = enonceTextField.getText();
        int note = Integer.parseInt(noteTextField.getText());
        QuestionLibre questionLibre = new QuestionLibre(enonce, note);
        try {
            DataManager.getInstance().getOrthophoniste().ajouterQuestion(questionLibre);
        } catch (ExceptionQuestionExistante e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("La question existe déjà");
        }
    }
    @FXML
    public void handleConfirmerButton() {
        try {
            addQuestionLibre();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QCM.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
