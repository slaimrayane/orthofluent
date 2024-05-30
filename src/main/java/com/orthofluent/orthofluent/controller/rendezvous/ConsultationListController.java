package com.orthofluent.orthofluent.controller.rendezvous;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Consultation;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.time.format.DateTimeFormatter;

public class ConsultationListController extends ListController {
    @FXML
    private TableView<Consultation> consultationTableView;
    @FXML
    private TableColumn<Consultation,String> nomColumn;
    @FXML
    private TableColumn<Consultation,String> prenomColumn;
    @FXML
    private TableColumn<Consultation,String> ageColumn;

    @FXML
    private TableColumn<Consultation, String> dateColumn;
    @FXML
    private TableColumn<Consultation, String> heureColumn;

    private ObservableList<Consultation> consultationObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        dateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Consultation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Consultation, String> param) {
                DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return new ReadOnlyStringWrapper(param.getValue().getDate().format(sdf));
            }
        });
        heureColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Consultation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Consultation, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getHeureDebut().toString());
            }
        });
        consultationObservableList.addAll(DataManager.getInstance().getOrthophoniste().getConsultations());
        consultationTableView.setItems(consultationObservableList);
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterConsultation.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            Consultation selectedItem = consultationTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                DataManager.getInstance().setRendezVous(selectedItem);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierConsultation.fxml", modifierToggleButton);
            }
        });
        supprimerToggleButton.setOnAction(event -> {
            Consultation selectedItem = consultationTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                consultationObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerRendezVous(selectedItem);
            }
        });
    }

}
