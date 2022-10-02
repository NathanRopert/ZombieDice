package com.example.ropert_nathan_tpjavafx.Des;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DesVert {
    public int FaceVert;
    private ArrayList<Integer> FaceDesVert = new ArrayList<>();

    public void AttributionFaceVert(){
        Collections.addAll(FaceDesVert, 1,1,1,2,2,3);
    }

    public void RandomFaceVert(){
        Collections.shuffle(FaceDesVert);
    }

    public int getFaceVert() {
        return FaceVert;
    }

    public void UneFaceVert(){
     FaceVert = FaceDesVert.get(0);
    }
    //voir des Jaunes
}
