package com.orthofluent.orthofluent.controller.rendezvous;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Atelier;
import com.orthofluent.orthofluent.models.PatientEnfant;
import com.orthofluent.orthofluent.models.Suivi;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class SuiviListController extends ListController {
    @FXML
    private TableView<Suivi> suiviTableView;

    @FXML
    private TableColumn<Suivi, String> numeroDossierColumn;
    @FXML
    private TableColumn<Suivi, String> dateColumn;
    @FXML
    private TableColumn<Suivi, String> heureColumn;
    @FXML
    private TableColumn<Suivi, String> typeColumn;

    private ObservableList<Suivi> suiviObservableList = FXCollections.observableArrayList();




    @FXML
    public void initialize() {
        numeroDossierColumn.setCellValueFactory(new PropertyValueFactory<>("numDossierPatient"));
        dateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Suivi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Suivi, String> param) {
                DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return new ReadOnlyStringWrapper(param.getValue().getDate().format(sdf));
            }
        });
        heureColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Suivi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Suivi, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getHeureDebut().toString());
            }
        });
        typeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Suivi, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Suivi, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().isPresentiel() ? "presentiel" : "en ligne");
            }
        });
        suiviObservableList.addAll(DataManager.getInstance().getOrthophoniste().getSuivis());
        suiviTableView.setItems(suiviObservableList);


        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterSuivi.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            Suivi selectedPatient = suiviTableView.getSelectionModel().getSelectedItem();
            if (selectedPatient != null) {
                DataManager.getInstance().setRendezVous(selectedPatient);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierSuivi.fxml", modifierToggleButton);
            }
        });
        supprimerToggleButton.setOnAction(event -> {
            Suivi suivi = suiviTableView.getSelectionModel().getSelectedItem();
            suiviObservableList.remove(suivi);
            // Here you can also add the code to delete the patient from the database
            DataManager.getInstance().getOrthophoniste().supprimerRendezVous(suivi);
        });
    }
}
