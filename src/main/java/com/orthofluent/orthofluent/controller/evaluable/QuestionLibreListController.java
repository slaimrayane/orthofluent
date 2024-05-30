package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QuestionLibre;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class QuestionLibreListController extends ListController {
    @FXML
    private TableView<QuestionLibre> questionLibreTableView;
    @FXML
    private TableColumn<QuestionLibre, String> enonceColumn;
    @FXML
    private TableColumn<QuestionLibre, Integer> noteColumn;

    private ObservableList<QuestionLibre> questionLibreObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        questionLibreObservableList.addAll(DataManager.getInstance().getOrthophoniste().getQuestionsLibres());
        enonceColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        questionLibreTableView.setItems(questionLibreObservableList);
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQuestLibre.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            QuestionLibre selectedItem = questionLibreTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                DataManager.getInstance().setQuestion(selectedItem);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierQuestLibre.fxml", modifierToggleButton);
            }
        });
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
