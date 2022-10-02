package com.example.ropert_nathan_tpjavafx;

import com.example.ropert_nathan_tpjavafx.Des.DesJaune;
import com.example.ropert_nathan_tpjavafx.Des.DesPerso;
import com.example.ropert_nathan_tpjavafx.Des.DesRouge;
import com.example.ropert_nathan_tpjavafx.Des.DesVert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Jeux extends Menu implements Initializable {
    private int i;
    @FXML
    private Label ScoreTotalJoueur;
    @FXML
    private static Button FinTour;
    @FXML
    private Label DesRouge;
    @FXML
    private Label DesVerts;
    @FXML
    private Label DesJaunes;
    @FXML
    private Label tirage1;
    @FXML
    private Label Tirage2;
    @FXML
    private Label TourJoueur;
    @FXML
    private Label ScoreActuelle;
    @FXML
    private Label Tirage3;
    private List<Integer> ListDes = new ArrayList();
    private List<Integer> MainDes = new ArrayList<>();
    private List<Integer> StrokageFaceEMP = new ArrayList<>();
    private int NbEmprinte = 0;
    private Score ScoreDesJoueur;
    private DesVert NewDesVert;
    private DesJaune NewDesJaune;
    private com.example.ropert_nathan_tpjavafx.Des.DesRouge NewDesRouge;
    private int NombreDeTour = 0;
    private static int Score = 0;
    private int NbDesVertTirer = 0;
    private int NbDesJauneTirer = 0;
    private int NbDesRougeTirer = 0;
    private int DesTirer;
    private static int NbFusil = 0;
    private static int NbCerveaux = 0;
    private List<Integer> NbDesCerveaux = new ArrayList();

    public Jeux() { //initilalisation pour appler les differente fonction des classe
        NewDesVert = new DesVert();
        NewDesRouge = new DesRouge();
        NewDesJaune = new DesJaune();
        ScoreDesJoueur = new Score();
    }

    public void AjouterDesListe() { //en fonction de le difficulter choisie on attribue les des dans une liste
        if (ChoixDeLaDifficulter == 1) {   //attribution pour la difficulter 1 8-3-2
            Collections.addAll(ListDes, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3); //les 1 son les des vert les 2 les des jaune eet 3 des rouges
        }
        if (ChoixDeLaDifficulter == 2) {     //attribution pour la difficulter 2 6-4-3
            Collections.addAll(ListDes, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3);
        }
        if (ChoixDeLaDifficulter == 3) {     //attribution pour la difficulter 3 4-5-4
            Collections.addAll(ListDes, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3);
        }
        if (ChoixDeLaDifficulter == 4) {    //attribution pour la difficulter des des personnaliser
            AjoutDeDesPersonaliser();   //appele de la fonction pour les attribution
        }
    }

    public void AjoutDeDesPersonaliser() { //fonction pour les des personnaliser
        while (i != DesPerso.NbAjVert) {    //on ajoute le nombre de des vert rentrer par le joueur
            ListDes.add(1); //ajout des des vert a le liste
            i++;
        }
        i = 0;
        while (i != DesPerso.NbAjJaune) {   //on ajoute le nombre de des jaune choisie
            ListDes.add(2); //ajout a la liste
            i++;
        }
        i = 0;
        while (i != DesPerso.NbAjRouge) {   //on ajoute a le nombre de des rouge choisie
            ListDes.add(3); //ajout a la liste
            i++;
        }
        i = 0; // reinitialisation du competeur pour une reutilisation
    }

    public void ListeMelange() {    // fonction qui melange les des dans la liste (le gobelet)
        Collections.shuffle(ListDes);   //melange la liste des des
    }

    public void TirageDes() {   //fonction de tirage des 3 des pour joueur
        InverserlzStocage();
        if (StrokageFaceEMP.get(0) == 100) {    //si il y a la valeur 100 dans la liste des des emprinte sela veut dire qu'il n'y a pas de des retenue
            while (i != 3) {    //on prends les 3 des dans la main pour les lancer
                MainDes.add(ListDes.get(0));    //on prends le 1 des du gobelet melanger et on l'ajoute dans la main du joueur
                ListDes.remove(0);  //on le retire du gobele
                i++;
            }
            i = 0;
        } else {    //si la liste des emprinte comptient un des
            while (i != 4 - StrokageFaceEMP.size()) {   //on ajoute le nombre de des du gobelet - le nombre de des dans la liste emprinte
                MainDes.add(ListDes.get(0));
                ListDes.remove(0);
                i++;
            }
            while (StrokageFaceEMP.get(0) != 100) { //tant que la liste ne contient pas la valeur 100 qui est la derniere valeur de repere
                MainDes.add(StrokageFaceEMP.get(0));    //on ajoute les des emprinte dans le la main pour les rejouer
                StrokageFaceEMP.remove(0); //on enleve le des de la liste
            }
            i = 0;
        }

    }

    public void AffichageDes() {    //foction pour afficher les des sur l'interface
        if (DesTirer == 1) {
            NbDesVertTirer += 1;    //ajout si on tire un des vert
        }
        if (DesTirer == 2) {
            NbDesJauneTirer += 1;   //ajout si on tire un des jaune
        }
        if (DesTirer == 3) {
            NbDesRougeTirer += 1;   //ajout si on tire un des rouge
        }
    }

    @FXML
    void TierLesDes(ActionEvent event) throws IOException { //button pour tirer les des dans la main
        if (ListDes.size() < 3) {   //si il y a moin de 3 des dans le gobelet on ajoute les des tirer avec un cerveaux
            while (!NbDesCerveaux.isEmpty()) {  //tant quelle est pas vide on ajoute
                ListDes.add(NbDesCerveaux.get(0));
                NbDesCerveaux.remove(0);
            }
        }
        TirageDes();    //on appele la fonction pour tirer les 3 des
        for (int i = 0; i != 3; i++) {  //pour les 3 des tirer on les recupere dans une varialbe
            DesTirer = MainDes.get(0);
            TirerLesFace(); //on appele la fonction pour tirer les face des des
            MainDes.remove(0);  // on enleve le des de la main
            AffichageDes(); //on affiche sur l'interface
        }
        ScoreDesJoueur.compteurScoreTotal();    //appele a la fonction du score du joueur
        DesVerts.setText(Integer.toString(NbDesVertTirer)); //affichage des des pour l'interface
        DesJaunes.setText(Integer.toString(NbDesJauneTirer));
        DesRouge.setText(Integer.toString(NbDesRougeTirer));
        Score = 0; // on mais le score a 0
        NbEmprinte = 0; //on mais les different compteur a 0
        NbDesVertTirer = 0;
        NbDesJauneTirer = 0;
        NbDesRougeTirer = 0;
        if (NbFusil >= 3) { //si il a tirer 3 fusil
            PassageDetour();    //on appele la fonction pour passe le tour
        }


    }

    public void TirerLesFace() {    //fonction pour tirer les face des des
        ScoreTotalJoueur.setText(Integer.toString(ScoreDesJoueur.TableauxDesScore[ScoreDesJoueur.a]));//affichage du socre du joueur
        if (DesTirer == 1) { //des vert tirer
            NewDesVert.RandomFaceVert();    // on melange les face
            NewDesVert.UneFaceVert();   //on prends une face
            recuperationEMPVert();  //si c'est une emprinte ou un cerveau on le reupere avec la fonction
        }
        if (DesTirer == 2) {    //des jaune tirer
            NewDesJaune.RandomFaceJaune();
            NewDesJaune.UneFaceJaune();
            recuperationEMPJaune();

        }
        if (DesTirer == 3) {    //des rouge tirer
            NewDesRouge.RandomFaceRouge();
            NewDesRouge.UneFaceRouge();
            recuperationEMPRouge();
        }
        tirage1.setText(Integer.toString(Score));   //affichage du nombre de cerveaux dans l'interface
        Tirage2.setText(Integer.toString(NbEmprinte));  //affiche des des emprinte
        Tirage3.setText(Integer.toString(NbFusil)); //affichage des des fusil
        ScoreTotalJoueur.setText(Integer.toString(ScoreDesJoueur.TableauxDesScore[ScoreDesJoueur.a]));  //affichage du score total
        ScoreActuelle.setText(Integer.toString(NbCerveaux));    //on affiche le score du joueur

    }

    public static int getNbCerveaux() { //envoie du nombre de cereaux
        return NbCerveaux;
    }

    public void recuperationEMPVert() { //fonction de recuperation des des cerveaux et emprinte
        if (NewDesVert.getFaceVert() == 2) {    //on ajoute dans la liste des des emprinte
            StockageEmp();  //ajoute
            NbEmprinte += 1;
        }
        if (NewDesVert.getFaceVert() == 1) {    //on ajoute dans la liste des des cereaux
            Score += 1;
            NbCerveaux += 1;
            StockageCerveaux(); //ajoute
        }
        if (NewDesVert.getFaceVert() == 3) {    //on ajoute +1 on nombre de fusl tirer
            NbFusil += 1;
        }
    }

    public void recuperationEMPJaune() {    //fonction de recuperation des des cerveaux et emprinte pour un des jaune
        if (NewDesJaune.getFaceJaune() == 2) {
            StockageEmp();
            NbEmprinte += 1;
        }
        if (NewDesJaune.getFaceJaune() == 1) {
            Score += 1;
            NbCerveaux += 1;
            StockageCerveaux();
        }
        if (NewDesJaune.getFaceJaune() == 3) {
            NbFusil += 1;
        }
    }

    public void recuperationEMPRouge() {    //fonction de recuperation des des cerveaux et emprinte pour un des rouge
        if (NewDesRouge.getFaceRouge() == 2) {
            StockageEmp();
            NbEmprinte += 1;
        }
        if (NewDesRouge.getFaceRouge() == 1) {
            Score += 1;
            NbCerveaux += 1;
            StockageCerveaux();
        }
        if (NewDesRouge.getFaceRouge() == 3) {
            NbFusil += 1;
        }
    }

    public static int getScore() {  //on envoie le score
        return Score;
    }

    public static int getNbFusil() {    //on envoie le nombre de fusil
        return NbFusil;
    }

    public void InverserlzStocage() {   //on inverse la liste des des face emprinte
        Collections.reverse(StrokageFaceEMP);
    }

    public void StockageEmp() { //fonction ajout a la liste emprinte
        StrokageFaceEMP.add(DesTirer);
    }

    public void StockageCerveaux() {    //fonction ajout a la liste des des cerveaux
        NbDesCerveaux.add(DesTirer);
    }

    @FXML
    void LancerLesDes(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    //lors de du lancement
        ScoreDesJoueur.JoueurDesDifferentScoreInit();
        AjouterDesListe();  // on ajoute a la liste les des
        ListeMelange(); //on melange la liste de des
        StrokageFaceEMP.add(100);   // on ajoute la valeur repere
        NewDesVert.AttributionFaceVert();   //on atribue les face
        NewDesVert.RandomFaceVert();    //on melange les face
        NewDesJaune.AttributionFaceJaune();
        NewDesJaune.RandomFaceJaune();
        NewDesRouge.AttributionFaceRouge();
        NewDesRouge.RandomFaceRouge();
    }

    public static void Fermeturefenetre() {
    }

    public void TirageDeux(MouseEvent mouseEvent) {

    }

    public void TirageUn(MouseEvent mouseEvent) {
    }

    public void TirageTrois(MouseEvent mouseEvent) {
    }

    public void PassageDetour() {   //fonction pour passer le tour
        ScoreActuelle.setText("0");
        Score = 0;  //initialisation du score a 0
        NbFusil = 0;
        NbCerveaux = 0;
        NbEmprinte = 0;
        ScoreDesJoueur.PassageJoueur(); //on appele la fonction du passage de tour
        TourJoueur.setText(Integer.toString(ScoreDesJoueur.a)); //on affiche le joeur
        ScoreTotalJoueur.setText(Integer.toString(ScoreDesJoueur.TableauxDesScore[ScoreDesJoueur.a]));  //on affiche le score du joueur
        NombreDeTour += 1;
        AjouterDesListe();  // on ajoute a la liste les des
        ListeMelange(); //on melange les des
        NewDesVert.AttributionFaceVert();
        NewDesVert.RandomFaceVert();
        NewDesJaune.AttributionFaceJaune();
        NewDesJaune.RandomFaceJaune();
        NewDesRouge.AttributionFaceRouge();
        NewDesRouge.RandomFaceRouge();
        DesVerts.setText("0");  //on initilalise l'affichage a 0
        DesJaunes.setText("0");
        DesRouge.setText("0");
        tirage1.setText("0");
        Tirage2.setText("0");
        Tirage3.setText("0");
    }

    @FXML
    void DesJaunesA(MouseEvent event) {

    }

    @FXML
    void DesRougeA(MouseEvent event) {

    }

    @FXML
    void DesVertsA(MouseEvent event) {

    }

    @FXML
    void FinDuTour(ActionEvent event) {
        PassageDetour();
    }
}
