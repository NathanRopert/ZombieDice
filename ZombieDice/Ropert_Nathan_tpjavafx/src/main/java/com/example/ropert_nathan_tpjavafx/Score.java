package com.example.ropert_nathan_tpjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

import static com.example.ropert_nathan_tpjavafx.Menu.NombreDeJoueurPartie;

public class Score {
    private int ScoreTotal;
    private int i = 1;
    public static int a = 0;
    private int b = 0;
    public static int[] TableauxDesScore = new int[NombreDeJoueurPartie];
    public static List ScoreFinal = new ArrayList<>();
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public void JoueurDesDifferentScoreInit() { //fonction initialisation des score
        while (i != NombreDeJoueurPartie) { //initialisation des score a 0 pour tout les joueur
            TableauxDesScore[i] = 0;
            i++;
        }
        i=0;
    }

    public void PassageJoueur() {   //fonction pour les joeur
        a++;
        if (a > NombreDeJoueurPartie - 1) { //si le nombre de joueur les depasser on passe au joueur 0
            a = 0;
        }
    }


    public void compteurScoreTotal() throws IOException { //fonction pour le score permanant
        ScoreTotal += Jeux.getScore();  //ajout du score du tour au score permanant
        TableauxDesScore[a] += ScoreTotal;  //ajout du score au joueur
        Score3Fusil();  //on appele la fonction des 3 fusil
        ScoreTotal = 0; //on mais le score total a 0
        ScoreVictoire();    // on appele la fonction de victoire
    }

    public void Score3Fusil() throws IOException {  //fonction pour 3 fusil
        if (Jeux.getNbFusil() >= 3) {   // si il tire 3 fusil
            TableauxDesScore[a] = TableauxDesScore[a] - Jeux.getNbCerveaux(); //on enleve le socre du tour au score total
            Fusil();    //on affiche un message avec une interface

        }
    }


    public void ScoreVictoire() throws IOException {    //fonction pour le score de victoire
        if (TableauxDesScore[a] >= 13) {    //si il a plus de 13 point
            Jeux.Fermeturefenetre();    //on appele la fonction de fermeture de fenetre
            AttribitionScore(); //on appele la fonction d'attribution des score
            AffichageTrier();   //on appele la fonction pour trier les score
            Fin();  //on lance le menu des score
            JoueurDesDifferentScoreInit();  //on reinitialise tout
            hm.clear();
            ScoreFinal.clear();
        }

    }

    public static void Fusil() throws IOException { //appele de l'interface si on a 3 fusil
        FXMLLoader fxmlLoader = new FXMLLoader(ZombieDiceApplication.class.getResource("Fusil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ropert Nathan Zombie Dice");
        stage.setScene(scene);
        stage.show();
    }

    public void AttribitionScore() {   //on attribue le score au joueur
        while (b != TableauxDesScore.length) {
            hm.put(b, TableauxDesScore[b]); //attribution grace a une hmap
            b++;
        }
        b = 0;
    }

    public void AffichageTrier() {  //on trie les score des diffierent joueur
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());    //on trie les score par order croissant
        Collections.reverse(list); // on les inverse pour que sela soit decroissiant
        while (!list.isEmpty()) {   //on ajoute le score et les joueur a la liste des score final
            ScoreFinal.add(list.get(0));
            list.remove(0);
        }
    }

    public void Fin() throws IOException {  //on charge la page de score

        FXMLLoader fxmlLoader = new FXMLLoader(ZombieDiceApplication.class.getResource("FinDePartie.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ropert Nathan Zombie Dice");
        stage.setScene(scene);
        stage.show();

    }

}

