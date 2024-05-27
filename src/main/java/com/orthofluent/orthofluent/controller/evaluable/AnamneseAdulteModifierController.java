package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import com.orthofluent.orthofluent.models.QuestionAnamneseAdulte;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AnamneseAdulteModifierController extends AjoutModifierController {
    @FXML
    private ComboBox<TypeQuestionAnamnese> typeQuestionAnamneseComboBox;
    @FXML
    private TextField enonceTextField;

    private QuestionAnamneseAdulte questionAnamneseAdulte;

    @FXML
    private void initialize() {
        ObservableList<TypeQuestionAnamnese> options = FXCollections.observableArrayList(TypeQuestionAnamnese.values());
        typeQuestionAnamneseComboBox.setItems(options);
        questionAnamneseAdulte =(QuestionAnamneseAdulte) DataManager.getInstance().getQuestionAnamnese();
        typeQuestionAnamneseComboBox.setValue(questionAnamneseAdulte.getTypeQuestionAnamnese());
        enonceTextField.setText(questionAnamneseAdulte.getEnonce());

        homeNavigation();

    }

        private void    UpdateQuestionAnamneseAdulte()  {
        TypeQuestionAnamnese typeQuestionAnamnese = typeQuestionAnamneseComboBox.getValue();
        String enonce = enonceTextField.getText();
        DataManager.getInstance().getOrthophoniste().modifierQuestionAnamnese(questionAnamneseAdulte, enonce, typeQuestionAnamnese);
    }
    @FXML
    private void handleConfirmeButton() {
        try {
            UpdateQuestionAnamneseAdulte();
            Parent root = FXMLLoader.load(getClass().getResource("/com/orthofluent/orthofluent/views/QuestAnamneseAdulte.fxml"));
            Stage stage = (Stage) confirmerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
