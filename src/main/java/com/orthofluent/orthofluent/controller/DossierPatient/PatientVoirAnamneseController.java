package com.orthofluent.orthofluent.controller.DossierPatient;

import com.orthofluent.orthofluent.controller.BaseController;
import com.orthofluent.orthofluent.models.DossierPatient;
import com.orthofluent.orthofluent.models.PatientAdulte;
import com.orthofluent.orthofluent.models.QuestionAnamnese;
import com.orthofluent.orthofluent.models.QuestionAnamneseEnfant;
import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;
import com.orthofluent.orthofluent.services.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PatientVoirAnamneseController extends BaseController {
    @FXML
    private TableView<QuestionAnamnese> questionAnamneseTableView;
    @FXML
    private TableColumn<QuestionAnamnese,String> questionColumn;
    @FXML
    private TableColumn<QuestionAnamnese,String> reponseColumn;
    @FXML
    private TableColumn<QuestionAnamnese, TypeQuestionAnamnese> typeQuestionColumn;
    @FXML
    private TextArea observationTextArea;
    @FXML
    private Button retourButton;
    @FXML
    private Button continuerButton;

    private DossierPatient dossierPatient;

    private ObservableList<QuestionAnamnese> questionAnamneseObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        typeQuestionColumn.setCellValueFactory(new PropertyValueFactory<>("typeQuestionAnamnese"));
        typeQuestionColumn.setCellFactory(column -> new TableCell<QuestionAnamnese, TypeQuestionAnamnese>() {
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
        reponseColumn.setCellValueFactory(new PropertyValueFactory<>("reponse"));
        DossierPatient dossierPatient = DataManager.getInstance().getDossierPatient();
        List<QuestionAnamnese> questionAnamneseList = dossierPatient.getQuestionOrthophoniqueList();
        questionAnamneseObservableList.addAll(questionAnamneseList);
        questionAnamneseTableView.setItems(questionAnamneseObservableList);

        homeNavigation();
    }


}
