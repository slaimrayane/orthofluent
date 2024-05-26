package com.orthofluent.orthofluent.controller.rendezvous;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Atelier;
import com.orthofluent.orthofluent.models.Suivi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class SuiviListController extends ListController {
    @FXML
    private TableView<Suivi> suiviTableView;

    private ObservableList<Atelier> suiviObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterSuivi.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierSuivi.fxml", modifierToggleButton));
        supprimerToggleButton.setOnAction(event -> {
            // Here you can also add the code to delete the patient from the database
        });
    }
}
