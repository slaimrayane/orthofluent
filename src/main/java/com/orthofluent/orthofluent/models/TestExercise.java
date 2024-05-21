package com.orthofluent.orthofluent.models;

import java.util.ArrayList;
import java.util.List;

public class TestExercise extends Test implements Score {
    private List<Exercise> exercice = new ArrayList<>();
    private float x;

    // constructeur
    public TestExercise(String nom, Capacite capacite, List<Exercise> exercice) {
        super(nom, capacite);
        this.exercice = exercice;
    }

    public void LancerTest() {

    };

    public float CalcScore() {
        return x;
    }
}