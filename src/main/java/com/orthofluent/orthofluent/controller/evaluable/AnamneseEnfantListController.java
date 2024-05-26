package com.orthofluent.orthofluent.controller.evaluable;


import com.orthofluent.orthofluent.controller.ListController;
import com.orthofluent.orthofluent.models.QuestionAnamneseEnfant;
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

public class AnamneseEnfantListController extends ListController {
    @FXML
    private TableColumn<QuestionAnamneseEnfant, String> enonceColumn;
    @FXML
    private TableColumn<QuestionAnamneseEnfant, TypeQuestionAnamnese> typeQuestionColumn;
    @FXML
    protected TableView<QuestionAnamneseEnfant> questionAnamneseEnfantTableView;

    private ObservableList<QuestionAnamneseEnfant> questionAnamneseEnfantObservableList = FXCollections.observableArrayList();

    @FXML
    private Button ajouterButton;
    @FXML
    private Button supprimerButton;
    @FXML
    public void initialize() {
        enonceColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        typeQuestionColumn.setCellValueFactory(new PropertyValueFactory<>("typeQuestionAnamnese"));
        typeQuestionColumn.setCellFactory(column -> new TableCell<QuestionAnamneseEnfant, TypeQuestionAnamnese>() {
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
        questionAnamneseEnfantObservableList.addAll(DataManager.getInstance().getOrthophoniste().getQuestionsAnamneseEnfant());
        questionAnamneseEnfantTableView.setItems(questionAnamneseEnfantObservableList);

        homeNavigation();
        ajouterToggleButton.setOnAction(event -> navigateTo("/com/orthofluent/orthofluent/views/AjouterQuestAnamneseEnfant.fxml", ajouterButton));

        modifierToggleButton.setOnAction(event-> navigateTo("/com/orthofluent/orthofluent/views/ModifierQuestAnamneseEnfant.fxml", modifierToggleButton));

        supprimerToggleButton.setOnAction(event -> {
            QuestionAnamneseEnfant selectedItem = questionAnamneseEnfantTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                questionAnamneseEnfantObservableList.remove(selectedItem);
                // Here you can also add the code to delete the patient from the database
                DataManager.getInstance().getOrthophoniste().supprimerQuestionAnamnese(selectedItem);
            }
        });

    }


}
