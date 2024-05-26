package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Exercise;
import com.orthofluent.orthofluent.models.QuestionAnamneseEnfant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ExerciceListController extends ListController {

    @FXML
    private TableView<Exercise> exerciceTableView;

    private ObservableList<Exercise> exerciceObservableList = FXCollections.observableArrayList();



    @FXML
    public void initialize() {


        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterExercice.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierExercice.fxml", modifierToggleButton));

        supprimerToggleButton.setOnAction(event -> {
            Exercise selectedItem = exerciceTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                exerciceObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerExercice(selectedItem);
            }
        });
    }
}
