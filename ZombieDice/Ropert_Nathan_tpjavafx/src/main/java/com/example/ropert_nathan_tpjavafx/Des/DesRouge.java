package com.example.ropert_nathan_tpjavafx.Des;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesRouge {
    public int FaceRouge;
    private ArrayList<Integer> FaceDesRouge ;

    public DesRouge(){
        FaceDesRouge = new ArrayList<Integer>();
    }

    public void AttributionFaceRouge(){
        Collections.addAll(FaceDesRouge, 3,3,3,2,2,1);
    }
    public void RandomFaceRouge(){
        Collections.shuffle(FaceDesRouge);
    }
    public void UneFaceRouge(){
        FaceRouge = FaceDesRouge.get(0);
    }
    public int getFaceRouge() {
        return FaceRouge;
    }
    //voir des Jaunes
}
