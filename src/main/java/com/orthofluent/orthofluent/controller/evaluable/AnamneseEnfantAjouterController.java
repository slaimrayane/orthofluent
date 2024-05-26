package com.orthofluent.orthofluent.controller.evaluable;


import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.QuestionAnamneseEnfant;
import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;
import com.orthofluent.orthofluent.models.exceptions.ExceptionCreationImpossible;
import com.orthofluent.orthofluent.models.exceptions.ExceptionQuestionAnamneseExistante;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AnamneseEnfantAjouterController extends AjoutModifierController {
    @FXML
    private ComboBox<TypeQuestionAnamnese> typeQuestionAnamneseComboBox;
    @FXML
    private TextField enonceTextField;
    @FXML
    private Button confirmButton;

    @FXML
    private void initialize() {
        ObservableList<TypeQuestionAnamnese> options = FXCollections.observableArrayList(TypeQuestionAnamnese.values());
        typeQuestionAnamneseComboBox.setItems(options);
        homeNavigation();

    }

        private void addQuestionAnamneseAdulte() throws ExceptionCreationImpossible {
        TypeQuestionAnamnese typeQuestionAnamnese = typeQuestionAnamneseComboBox.getValue();
        String enonce = enonceTextField.getText();
        QuestionAnamneseEnfant questionAnamneseEnfant = new QuestionAnamneseEnfant(typeQuestionAnamnese, enonce);
        try {
            DataManager.getInstance().getOrthophoniste().ajouterQuestionAnamnese(questionAnamneseEnfant);
        } catch (ExceptionQuestionAnamneseExistante e) {
            e.printStackTrace();
            throw new ExceptionCreationImpossible("Erreur lors de l'ajout de la question d'anamnese");
        }
    }
    @FXML
    private void handleConfirmeButton() {
        try {
            addQuestionAnamneseAdulte();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QuestAnamneseEnfant.fxml"));
            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (ExceptionCreationImpossible e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
