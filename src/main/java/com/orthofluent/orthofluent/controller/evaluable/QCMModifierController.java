package com.orthofluent.orthofluent.controller.evaluable;

import com.orthofluent.orthofluent.controller.AjoutModifierController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class QCMModifierController extends AjoutModifierController {
    @FXML
    private TextField questionField;
    @FXML
    private TextField proposition1Field;
    @FXML
    private TextField proposition2Field;
    @FXML
    private TextField proposition3Field;
    @FXML
    private CheckBox proposition1CheckBox;
    @FXML
    private CheckBox proposition2CheckBox;
    @FXML
    private CheckBox proposition3CheckBox;

    @FXML
    private void initialize() {
        homeNavigation();

    }
}
