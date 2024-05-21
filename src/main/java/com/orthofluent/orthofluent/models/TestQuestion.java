package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.security.SecureRandomParameters;
import java.util.ArrayList;
import java.util.List;

//nzido une methode qui affiche la liste des question ..win?
public class TestQuestion extends Test implements Score, Serializable {
    private List<Question> questions = new ArrayList<>();
    private float x;

    public TestQuestion(String nom, Capacite capacite, List<Question> questions) {
        super(nom, capacite);
        this.questions = questions;
    }

    public void LancerTest() {

    };

    public float CalcScore() {
        return x;
    }
}
