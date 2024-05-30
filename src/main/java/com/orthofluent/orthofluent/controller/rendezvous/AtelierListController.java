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
    @FXML
    private TableColumn<Atelier, String> dateColumn;
    @FXML
    private TableColumn<Atelier, String> heureColumn;
    @FXML
    private TableColumn<Atelier, String> thematiqueColumn;
    @FXML
    private TableColumn<Atelier, String> patientNameColumn;
    @FXML
    private TableColumn<Atelier, String> patientPrenomColumn;
    @FXML
    private TableColumn<Atelier, String> NumeroDossierColumn;



    private ObservableList<Atelier> atelierObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        homeNavigation();
        atelierObservableList.addAll(DataManager.getInstance().getOrthophoniste().getAteliers());
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
