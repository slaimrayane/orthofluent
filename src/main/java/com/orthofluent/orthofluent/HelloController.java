package com.orthofluent.orthofluent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class HelloController {
     @FXML
    private Button myButton;

    @FXML
    private Label myLabel;

    @FXML
    private void handleButtonClick() {
        myLabel.setVisible(true);
    }
}