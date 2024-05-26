package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QCU;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class QCUListController extends ListController {
    @FXML
    private TableView<QCU> qcuTableView;

    private ObservableList<QCU> qcuObservableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQCU.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierQCU.fxml", modifierToggleButton));
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
