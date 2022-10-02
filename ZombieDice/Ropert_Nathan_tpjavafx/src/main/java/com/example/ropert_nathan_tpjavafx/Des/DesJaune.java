package com.example.ropert_nathan_tpjavafx.Des;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesJaune  {
    public int FaceJaune;
    private ArrayList<Integer> FaceDesJaune = new ArrayList<Integer>();

    public void AttributionFaceJaune(){ //attibution des face du des
        Collections.addAll(FaceDesJaune, 1,1,2,2,3,3);  //face 1 cerveaux 2 emprinte 3 fusil
    }
    public void RandomFaceJaune(){
        Collections.shuffle(FaceDesJaune);  //fonction pour melanger les face
    }

    public void UneFaceJaune(){
        FaceJaune = FaceDesJaune.get(0);//recuperation de la face du des
    }

    public int getFaceJaune() {
        return FaceJaune;   //  on envoie la face du des
    }
    //meme schema de construction pour les des Vert et Rouge

}
