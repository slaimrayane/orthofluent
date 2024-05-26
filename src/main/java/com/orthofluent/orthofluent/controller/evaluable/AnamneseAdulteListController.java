package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QuestionAnamneseAdulte;
import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnamneseAdulteListController extends ListController {
    @FXML
    private TableColumn<QuestionAnamneseAdulte, String> enonceColumn;
    @FXML
    private TableColumn<QuestionAnamneseAdulte, TypeQuestionAnamnese> typeQuestionColumn;
    @FXML
    protected TableView<QuestionAnamneseAdulte> questionAnamneseAdulteTableView;

    private ObservableList<QuestionAnamneseAdulte> questionAnamneseAdulteObservableList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        enonceColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        typeQuestionColumn.setCellValueFactory(new PropertyValueFactory<>("typeQuestionAnamnese"));
        typeQuestionColumn.setCellFactory(column -> new TableCell<QuestionAnamneseAdulte, TypeQuestionAnamnese>() {
        @Override
        protected void updateItem(TypeQuestionAnamnese item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
            } else {
                // Customize how the enumeration is displayed here
                setText(item.toString());
            }
    }
});
        questionAnamneseAdulteObservableList.addAll(DataManager.getInstance().getOrthophoniste().getQuestionsAnamneseAdulte());
        questionAnamneseAdulteTableView.setItems(questionAnamneseAdulteObservableList);

        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQuestAnamneseAdulte.fxml", ajouterToggleButton));

        modifierToggleButton.setOnAction(event-> navigateTo("/com/orthofluent/orthofluent/views/ModifierQuestAnamneseAdulte.fxml", modifierToggleButton));

        supprimerToggleButton.setOnAction(event -> {
            QuestionAnamneseAdulte selectedItem = questionAnamneseAdulteTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                questionAnamneseAdulteObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerQuestionAnamnese(selectedItem);
            }
        });

    }


}
