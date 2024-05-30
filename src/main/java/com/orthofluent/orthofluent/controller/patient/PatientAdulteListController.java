package com.orthofluent.orthofluent.controller.patient;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.DossierPatient;
import com.orthofluent.orthofluent.models.PatientAdulte;
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

import java.text.SimpleDateFormat;

public class PatientAdulteListController extends ListController {
    @FXML
    protected TableView<PatientAdulte> patientTableView;

    private ObservableList<PatientAdulte> patientAdulteObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<PatientAdulte, String> dateNaissanceColumn;
    @FXML
    private TableColumn<PatientAdulte, String> nomColumn;
    @FXML
    private TableColumn<PatientAdulte, String> prenomColumn;
    @FXML
    private TableColumn<PatientAdulte, String> ageColumn;
    @FXML
    private TableColumn<PatientAdulte, String> adresseColumn;
    @FXML
    private TableColumn<PatientAdulte, String> telephonePremierColumn;

    @FXML
    private TableColumn<PatientAdulte, String> professionColumn;
    @FXML
    private TableColumn<PatientAdulte, String> diplomeColumn;

    @FXML
    private ToggleButton voirToggleButton;

    @FXML
    public void initialize() {


        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));

        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("addresse"));

        telephonePremierColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        diplomeColumn.setCellValueFactory(new PropertyValueFactory<>("diplome"));

        professionColumn.setCellValueFactory(new PropertyValueFactory<>("profession"));

        dateNaissanceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PatientAdulte, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PatientAdulte, String> param) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return new ReadOnlyStringWrapper(sdf.format(param.getValue().getDateNaissance()));
            }
        });

        patientAdulteObservableList.addAll(DataManager.getInstance().getOrthophoniste().getPatientsAdultes());
        patientTableView.setItems(patientAdulteObservableList);

        //clickable button
        homeNavigation();

        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterPatientAdulte.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            PatientAdulte selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            if (selectedPatient != null) {
                DataManager.getInstance().setPatient(selectedPatient);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierPatientAdulte.fxml", modifierToggleButton);
            }
        });
        supprimerToggleButton.setOnAction(event -> {
            PatientAdulte selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            if (selectedPatient != null) {
                patientAdulteObservableList.remove(selectedPatient);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerDossierPatient(selectedPatient);
            }
        });
        voirToggleButton.setOnAction(event -> {
            PatientAdulte selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            if (selectedPatient != null) {
                DataManager.getInstance().setPatient(selectedPatient);
                DossierPatient dossierPatient = DataManager.getInstance().getOrthophoniste().getPatients(selectedPatient);
                DataManager.getInstance().setDossierPatient(dossierPatient);
                navigateTo("/com/orthofluent/orthofluent/views/DossierAdulte.fxml", voirToggleButton);
            }
        });

    }

}
