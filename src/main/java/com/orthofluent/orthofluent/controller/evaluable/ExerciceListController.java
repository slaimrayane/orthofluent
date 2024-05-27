package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Exercise;
import com.orthofluent.orthofluent.models.QuestionAnamneseEnfant;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExerciceListController extends ListController {

    @FXML
    private TableView<Exercise> exerciceTableView;
    @FXML
    private TableColumn<Exercise, String> enonceColumn;
    @FXML
    private TableColumn<Exercise, Integer> noteColumn;
    @FXML
    private TableColumn<Exercise, String> materielColumn;

    private ObservableList<Exercise> exerciceObservableList = FXCollections.observableArrayList();



    @FXML
    public void initialize() {
        exerciceObservableList.addAll(DataManager.getInstance().getOrthophoniste().getExercises());
        enonceColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        materielColumn.setCellValueFactory(new PropertyValueFactory<>("materiel"));
        exerciceTableView.setItems(exerciceObservableList);

        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterExercice.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            Exercise selectedItem = exerciceTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                DataManager.getInstance().setExercise(selectedItem);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierExercice.fxml", modifierToggleButton);
            }
        });
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
