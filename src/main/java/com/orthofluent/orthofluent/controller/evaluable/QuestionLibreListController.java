package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QuestionLibre;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class QuestionLibreListController extends ListController {
    @FXML
    private TableView<QuestionLibre> questionLibreTableView;

    private ObservableList<QuestionLibre> questionLibreObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQuestionLibre.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierQuestionLibre.fxml", modifierToggleButton));
        supprimerToggleButton.setOnAction(event -> {
            QuestionLibre selectedItem = questionLibreTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                questionLibreObservableList.remove(selectedItem);
                // Here you can add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerQuestion(selectedItem);

            }
        });
    }
}
