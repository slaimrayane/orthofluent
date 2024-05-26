package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Proposition;
import com.orthofluent.orthofluent.models.QCM;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class QCMListController extends ListController {
    @FXML
    private TableView<QCM> qcmTableView;

    private ObservableList<QCM> qcmObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<QCM, String> questionColumn;
    @FXML
    private TableColumn<QCM, String> proposition1Column;
    @FXML
    private TableColumn<QCM, String> proposition2Column;
    @FXML
    private TableColumn<QCM, String> proposition3Column;


    @FXML
    public void initialize() {
        questionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEnonce()));
        proposition1Column.setCellValueFactory(cellData -> {
           List<Proposition> propositions = cellData.getValue().getPropositionsList();
           return new SimpleStringProperty(propositions.size() > 0 ? propositions.get(0).toString() : "Default Value");
        });

        proposition2Column.setCellValueFactory(cellData -> {
            List<Proposition> propositions = cellData.getValue().getPropositionsList();
            return new SimpleStringProperty(propositions.size() > 1 ? propositions.get(1).toString() : "Default Value");
        });

        proposition3Column.setCellValueFactory(cellData -> {
            List<Proposition> propositions = cellData.getValue().getPropositionsList();
            return new SimpleStringProperty(propositions.size() > 2 ? propositions.get(2).toString() : "Default Value");
        });
        qcmObservableList.addAll(DataManager.getInstance().getOrthophoniste().getQCM());
        qcmTableView.setItems(qcmObservableList);

        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQCM.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            QCM selectedItem = qcmTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                DataManager.getInstance().setQuestion(selectedItem);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierQCM.fxml", modifierToggleButton);
            }
        });
        supprimerToggleButton.setOnAction(event -> {
            QCM selectedItem = qcmTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                qcmObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerQuestion(selectedItem);
            }
        });
    }

}
