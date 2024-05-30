package com.orthofluent.orthofluent.controller.DossierPatient;

import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.DossierPatient;
import com.orthofluent.orthofluent.models.EpreuveClinique;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;

import java.util.List;

public class PatientVoirEpreuveCliniqueController extends BaseController {
    @FXML
    private TableView<EpreuveClinique> epreuveCliniqueTableView;
    @FXML
    private TableColumn<EpreuveClinique, String> observationCliniqueColumn;
    @FXML
    private TableColumn<EpreuveClinique, String> testColumn;
    @FXML
    private TableColumn<EpreuveClinique, String> scoreColumn;
    @FXML
    private Button retourButton;
    @FXML
    private Button continuerButton;

    private ObservableList<EpreuveClinique> epreuveCliniqueObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        observationCliniqueColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getObservationClinique().getObservationClinique()));
        testColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTest().getNom()));
        scoreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTest().getCompteRendu().getScore())));
        DossierPatient dossierPatient = DataManager.getInstance().getDossierPatient();
        List<EpreuveClinique> epreuveCliniqueList = dossierPatient.getEpreuveCliniqueList();
        epreuveCliniqueObservableList.addAll(epreuveCliniqueList);
        epreuveCliniqueTableView.setItems(epreuveCliniqueObservableList);

    }
}
