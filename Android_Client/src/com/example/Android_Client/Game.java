package com.example.Android_Client;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by s213391244 on 10/13/2015.
 */
public class Game extends Activity {

    private ArrayList<Die> dice;
    private ArrayList<Die> selectedDice;

    private int numberOfBrains;

    private ImageView imgA;
    private ImageView imgB;
    private ImageView imgC;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        imgA = (ImageView) findViewById(R.id.imageA);
        imgB = (ImageView) findViewById(R.id.imageB);
        imgC = (ImageView) findViewById(R.id.imageC);

        numberOfBrains = 0;
        initiateDice();
    }

    public void roll(View view) {
        throwDice();
        evaluateThrownDice();
        rearrangeDice();

        if (selectedDice.size() == 0) {
            selectDiceWithoutRunners();
        } else {
            selectDiceWithRunners();
        }
    }

    private void initiateDice() {
        setDice();
        selectDiceWithoutRunners();
    }

    private void evaluateThrownDice() {
        for (Die die : selectedDice) {
            if (die.getSelectedFace().getType() == "brain") {
                numberOfBrains++;
            }
        }
    }

    private void rearrangeDice() {
        ArrayList<Die> runners = new ArrayList<Die>();
        for (Die die : selectedDice) {
            if (die.getSelectedFace().getType() == "runner") {
                runners.add(die);
            } else {
                dice.add(die);
            }
        }
        selectedDice = runners;
    }

    private void selectDiceWithRunners() {
        for (int x = selectedDice.size(); x < 3; x++) {
            selectedDice.add(getRandomDie(12 - x));
        }
    }

    private void setDice() {
        dice = new ArrayList<Die>();
        int green = 6;
        int yellow = 4;
        int red = 3;

        for (int x = 0; x < green; x++) {
            ArrayList<Face> faces = new ArrayList<Face>();
            for (int y = 0; y < 3; y++) {
                Face newFace = new Face("brain");
                faces.add(newFace);
            }
            for (int y = 0; y < 1; y++) {
                Face newFace = new Face("shotgun");
                faces.add(newFace);
            }
            for (int y = 0; y < 2; y++) {
                Face newFace = new Face("runner");
                faces.add(newFace);
            }
            Die newDice = new Die("green", faces);
            dice.add(newDice);
        }
        for (int x = 0; x < yellow; x++) {
            ArrayList<Face> faces = new ArrayList<Face>();
            for (int y = 0; y < 2; y++) {
                Face newFace = new Face("brain");
                faces.add(newFace);
            }
            for (int y = 0; y < 2; y++) {
                Face newFace = new Face("shotgun");
                faces.add(newFace);
            }
            for (int y = 0; y < 2; y++) {
                Face newFace = new Face("runner");
                faces.add(newFace);
            }
            Die newDice = new Die("yellow", faces);
            dice.add(newDice);
        }
        for (int x = 0; x < red; x++) {
            ArrayList<Face> faces = new ArrayList<Face>();
            for (int y = 0; y < 1; y++) {
                Face newFace = new Face("brain");
                faces.add(newFace);
            }
            for (int y = 0; y < 3; y++) {
                Face newFace = new Face("shotgun");
                faces.add(newFace);
            }
            for (int y = 0; y < 2; y++) {
                Face newFace = new Face("runner");
                faces.add(newFace);
            }
            Die newDice = new Die("red", faces);
            dice.add(newDice);
        }
    }

    private void selectDiceWithoutRunners() {
        selectedDice = new ArrayList<Die>();
        for (int x = 0; x < 3; x++) {
            selectedDice.add(getRandomDie(12 - x));
        }
    }

    private void throwDice() {
        Die die = selectedDice.get(0);
        die.selectRandomFace();
        String fileA = die.getColour() + "_" + die.getSelectedFace().getType();

        die = selectedDice.get(1);
        die.selectRandomFace();
        String fileB = die.getColour() + "_" + die.getSelectedFace().getType();

        die = selectedDice.get(2);
        die.selectRandomFace();
        String fileC = die.getColour() + "_" + die.getSelectedFace().getType();

        Resources res = getResources();
        int resID = res.getIdentifier(fileA, "drawable", getPackageName());
        imgA.setImageResource(resID);

        resID = res.getIdentifier(fileB, "drawable", getPackageName());
        imgB.setImageResource(resID);

        resID = res.getIdentifier(fileC, "drawable", getPackageName());
        imgC.setImageResource(resID);
    }

    private Die getRandomDie(int seed) {
        Random random = new Random();
        int R = random.nextInt(seed);
        return dice.remove(R);
    }
}