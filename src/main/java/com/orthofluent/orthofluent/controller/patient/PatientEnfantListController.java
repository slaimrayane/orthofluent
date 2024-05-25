package com.orthofluent.orthofluent.controller.patient;


import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.PatientEnfant;
import com.orthofluent.orthofluent.services.DataManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.text.SimpleDateFormat;
import javafx.beans.value.ObservableValue;

import javafx.beans.property.ReadOnlyStringWrapper;


public class PatientEnfantListController extends ListController {
    @FXML
    private TableColumn<PatientEnfant, String> dateNaissanceColumn;
    @FXML
    private TableColumn<PatientEnfant, String> nomColumn;
    @FXML
    private TableColumn<PatientEnfant, String> prenomColumn;
    @FXML
    private TableColumn<PatientEnfant, String> ageColumn;
    @FXML
    private TableColumn<PatientEnfant, String> adresseColumn;
    @FXML
    private TableColumn<PatientEnfant, String> telephonePremierColumn;
    @FXML
    private TableColumn<PatientEnfant, String> telephoneSecondColumn;
    @FXML
    private TableColumn<PatientEnfant, String> classeEtudeColumn;
    @FXML
    protected TableView<PatientEnfant> patientTableView;

    private ObservableList<PatientEnfant> patientEnfantObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));

        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("addresse"));

        telephonePremierColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        telephoneSecondColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneparent"));

        classeEtudeColumn.setCellValueFactory(new PropertyValueFactory<>("classEtude"));

        dateNaissanceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PatientEnfant, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PatientEnfant, String> param) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return new ReadOnlyStringWrapper(sdf.format(param.getValue().getDateNaissance()));
            }
        });

        patientEnfantObservableList.addAll(DataManager.getInstance().getOrthophoniste().getPatientsEnfants());
        patientTableView.setItems(patientEnfantObservableList);

        //clickable button
        homeNavigation();

        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterPatientEnfant.fxml", ajouterToggleButton));

        supprimerToggleButton.setOnAction(event -> {
            PatientEnfant selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            if (selectedPatient != null) {
                patientEnfantObservableList.remove(selectedPatient);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerDossierPatient(selectedPatient);
            }
        });
    }
}
