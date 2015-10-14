package com.example.Android_Client;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by s213391244 on 10/13/2015.
 */
public class Die {
    private String colour;
    private ArrayList<Face> faces;
    private Face selectedFace;

    public Die(String colour, ArrayList<Face> faces) {
        this.colour = colour;
        this.faces = faces;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public void setFaces(ArrayList<Face> faces) {
        this.faces = faces;
    }

    public void selectRandomFace(){
        Random random = new Random();
        int R = random.nextInt(6);
        selectedFace = faces.get(R);
    }

    public Face getSelectedFace() {
        return selectedFace;
    }

    public void setSelectedFace(Face selectedFace) {
        this.selectedFace = selectedFace;
    }
}
