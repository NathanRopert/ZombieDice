package com.example.ropert_nathan_tpjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.PrivateKey;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @FXML
    private CheckBox modfacile;
    @FXML
    private CheckBox modmoyen;
    @FXML
    private CheckBox moddifficile;
    @FXML
    private CheckBox Nbj2;
    @FXML
    private CheckBox Nbj3;
    @FXML
    private CheckBox Nbj4;
    @FXML
    private CheckBox Nbj5;
    @FXML
    private Button Lance;
    @FXML
    private Button ajoutDes;
    static int NombreDeJoueurPartie = 2;
    static int ChoixDeLaDifficulter;

    @FXML
    void selecfacile(ActionEvent event) {   // liaison avec les checkBox pour la difficulter 1
        ChoixDeLaDifficulter = 1;   //attribution de la difficulter
        if (modfacile.isSelected()) {   //quand on coche une autre checkBox elle est decocher automatiquement
            modmoyen.setSelected(false);
            moddifficile.setSelected(false);
        } else {
            modfacile.setSelected(true);
        }
    }

    @FXML
    void selecmoyen(ActionEvent event) {    // liaison avec les checkBox pour la difficulter 2
        ChoixDeLaDifficulter = 2;
        if (modmoyen.isSelected()) {
            modfacile.setSelected(false);
            moddifficile.setSelected(false);
        } else {
            modmoyen.setSelected(true);
        }
    }

    @FXML
    void selecdifficile(ActionEvent event) {    // liaison avec les checkBox pour la difficulter 3
        ChoixDeLaDifficulter = 3;
        if (moddifficile.isSelected()) {
            modfacile.setSelected(false);
            modmoyen.setSelected(false);
        } else {
            moddifficile.setSelected(true);
        }
    }

    @FXML
    void deuxjoueur(ActionEvent event) {    //liaison avec les Check box pour avoir le nombre de joueur
        NombreDeJoueurPartie = 2;
        if (Nbj2.isSelected()) {    //Quand une check box est chcher on decoche les autre checkBox
            Nbj3.setSelected(false);
            Nbj4.setSelected(false);
            Nbj5.setSelected(false);
        } else {
            Nbj2.setSelected(true);
        }

    }

    @FXML
    void troisjoueur(ActionEvent event) {   //liaison avec les Check box pour avoir le nombre de joueur
        NombreDeJoueurPartie = 3;
        if (Nbj3.isSelected()) {
            Nbj2.setSelected(false);
            Nbj4.setSelected(false);
            Nbj5.setSelected(false);
        } else {
            Nbj3.setSelected(true);
        }
    }

    @FXML
    void quatrejoueur(ActionEvent event) { //liaison avec les Check box pour avoir le nombre de joueur
        NombreDeJoueurPartie = 4;
        if (Nbj4.isSelected()) {
            Nbj3.setSelected(false);
            Nbj2.setSelected(false);
            Nbj5.setSelected(false);
        } else {
            Nbj4.setSelected(true);
        }
    }

    @FXML
    void cinqjoueur(ActionEvent event) {    //liaison avec les Check box pour avoir le nombre de joueur
        NombreDeJoueurPartie = 5;
        if (Nbj5.isSelected()) {
            Nbj3.setSelected(false);
            Nbj4.setSelected(false);
            Nbj2.setSelected(false);
        } else {
            Nbj5.setSelected(true);
        }
    }

    @FXML
    void LancerLeJeux(ActionEvent event) throws IOException {   //quand on a choisie la difficulter et les joueur on lance la page de jeux
        FXMLLoader fxmlLoader = new FXMLLoader(ZombieDiceApplication.class.getResource("Jeux.fxml"));   //chargement de la page
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ropert Nathan Zombie Dice");
        stage.setScene(scene);
        stage.show();
        Jeux.setData(ChoixDeLaDifficulter); //recuperation de la difficulter choisie
        Jeux.setNombreDeJoueurPartie(NombreDeJoueurPartie); //recuperation des joueur choisie
        stage = (Stage) Lance.getScene().getWindow();
        stage.close();
    }

    public static void setData(int choixDeLaDifficulter) {  //recuperation du choix de la dificulter choisie par le joueur
        ChoixDeLaDifficulter = choixDeLaDifficulter;
    }

    public static void setNombreDeJoueurPartie(int nombreDeJoueurPartie) {  //recuperation du choix du nombre de joueur dans la partie
        NombreDeJoueurPartie = nombreDeJoueurPartie;
    }

    @FXML
    void DesPersonaliser(ActionEvent event) throws IOException {    //ouverture de la fenetre pour choisir le nombre de des personnaliser
        FXMLLoader fxmlLoader = new FXMLLoader(ZombieDiceApplication.class.getResource("DesPerso.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ropert Nathan Zombie Dice");
        stage.setScene(scene);
        stage.show();
        ChoixDeLaDifficulter = 4;   //Attribution du nouveaux mode de difficulter
        modfacile.setSelected(false); //on decohe les autre mode de difficulter quand on choisie les des personnaliser
        modmoyen.setSelected(false);
        moddifficile.setSelected(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

