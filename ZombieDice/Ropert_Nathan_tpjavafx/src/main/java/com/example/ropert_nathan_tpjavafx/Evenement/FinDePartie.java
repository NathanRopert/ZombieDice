package com.example.ropert_nathan_tpjavafx.Evenement;

import com.example.ropert_nathan_tpjavafx.Menu;
import com.example.ropert_nathan_tpjavafx.Score;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.*;

public class FinDePartie extends Menu implements Initializable {
    @FXML
    private ListView tabscore;
    @FXML
    private Button Quitter;

    @FXML
    void ButtonQuitter(ActionEvent event) {
        Platform.exit();
    }

    private int compteur = 0;

    public Score LeScoreFinal = new Score();

    public void Affjoueur() {   //affichage des joeur dans le classement
        while (compteur != Score.ScoreFinal.size()) { //pour tout les joueur de la liste
            tabscore.getItems().add("Joueur " + LeScoreFinal.ScoreFinal.get(compteur));
            compteur++;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Affjoueur();    //quand la page se lance on appele la fonction pour afficher les joeur
    }

}
