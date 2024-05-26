package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QCM;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class QCMListController extends ListController {
    @FXML
    private TableView<QCM> qcmTableView;

    private ObservableList<QCM> qcmObservableList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQCM.fxml", ajouterToggleButton));
        modifierToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/ModifierQCM.fxml", modifierToggleButton));
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
