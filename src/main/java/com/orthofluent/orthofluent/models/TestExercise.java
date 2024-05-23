package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Capacite;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestExercise extends Test implements  Serializable {
    private List<Exercise> exercice = new ArrayList<>();
    private float x;

    // constructeur
    public TestExercise(String nom, Capacite capacite, List<Exercise> exercice) {
        super(nom, capacite);
        this.exercice = exercice;
    }

 public  void evaluerTest(String conclusion, String remarque){

 }
}