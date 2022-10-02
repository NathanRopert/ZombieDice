package com.example.ropert_nathan_tpjavafx.Evenement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Fusil {
    @FXML
    private Button daccord;

    @FXML
    void daccordbutton(ActionEvent event) { //button pour fermer le fenetre d'inormation 3 fusil
        Stage stage = (Stage) daccord.getScene().getWindow();
        stage.close();
    }
}
