package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.Proposition;
import com.orthofluent.orthofluent.models.QCM;
import com.orthofluent.orthofluent.models.QCU;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class QCUListController extends ListController {
    @FXML
    private TableView<QCU> qcuTableView;

    private ObservableList<QCU> qcuObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<QCU, String> questionColumn;
    @FXML
    private TableColumn<QCU, String> proposition1Column;
    @FXML
    private TableColumn<QCU, String> proposition2Column;
    @FXML
    private TableColumn<QCU, String> proposition3Column;


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
        qcuObservableList.addAll(DataManager.getInstance().getOrthophoniste().getQCU());
        qcuTableView.setItems(qcuObservableList);

        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQCU.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> {
            QCU selectedItem = qcuTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                DataManager.getInstance().setQuestion(selectedItem);
                navigateTo("/com/orthofluent/orthofluent/views/ModifierQCU.fxml", modifierToggleButton);
            }
        });
        supprimerToggleButton.setOnAction(event -> {
            QCU selectedItem = qcuTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                qcuObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerQuestion(selectedItem);
            }
        });
    }

}
