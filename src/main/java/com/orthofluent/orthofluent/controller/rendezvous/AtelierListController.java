package com.orthofluent.orthofluent.controller.rendezvous;

import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Atelier;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AtelierListController extends ListController {
    @FXML
    private TableView<Atelier> atelierTableView;

    private ObservableList<Atelier> atelierObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterAtelier.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierAtelier.fxml", modifierToggleButton));
        supprimerToggleButton.setOnAction(event -> {
            Atelier selectedItem = atelierTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                atelierObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerRendezVous(selectedItem);
            }
        });
    }
}
