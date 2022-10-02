package com.example.ropert_nathan_tpjavafx.Des;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DesPerso implements Initializable {

    public static int NbAjVert = 8;
    public static int NbAjJaune = 3;
    public static int NbAjRouge = 2;
    @FXML
    private TextField AjoutDesVert;

    @FXML
    private TextField AjoutDesJaune;

    @FXML
    private TextField AjoutDesRouge;
    @FXML
    private Button EnvoyerValeur;
    private String AjtNbDeVert;
    private String AjtNbDeJaune;
    private String AjtNbDeRouge;

    @FXML
    void AjtDesJaune(ActionEvent event) {

    }

    @FXML
    void AjtDesRouge(ActionEvent event) {

    }

    @FXML
    void AjtDesVert(ActionEvent event) {

    }

    @FXML
    void Envoyer(ActionEvent event) { //quand on appuis le button
        AjtNbDeVert = AjoutDesVert.getText();   //recupration du nombre de des que l'on veut ajouter
        AjtNbDeJaune = AjoutDesJaune.getText();
        AjtNbDeRouge = AjoutDesRouge.getText();

        try {
            NbAjVert = Integer.parseInt(AjtNbDeVert);   //transformation de la valeur en int
        } catch (Exception e) {
            NbAjVert = 8;   //si la valeur rentrer ne correspond pas ( rien ou bonjour ) on ajoute une valeur par defaut
        }
        //on fait le meme chose pour les autre des
        try {
            NbAjJaune = Integer.parseInt(AjtNbDeJaune);
        } catch (Exception e) {
            NbAjJaune = 3;
        }
        try {
            NbAjRouge = Integer.parseInt(AjtNbDeRouge);
        } catch (Exception e) {
            NbAjRouge = 2;
        }
        Stage stage = (Stage) EnvoyerValeur.getScene().getWindow(); // on ferme la fenetre des des personnaliser 
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
