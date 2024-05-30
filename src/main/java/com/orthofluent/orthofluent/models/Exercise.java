package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionScoreErronee;

import java.io.Serializable;

public class Exercise extends Evaluable implements Serializable {
    private String enonce;
    private String materiel;

    public Exercise(String enonce, String materiel) {
        this.enonce = enonce;
        this.materiel = materiel;
    }
    public Exercise(String enonce, int note, String materiel) {
        this.enonce = enonce;
        this.materiel = materiel;
        setNote(note);
    }
    public Exercise() {
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void evaluer(int score) throws ExceptionScoreErronee {
        if (score < 0 || score > getNote()) {
            throw new ExceptionScoreErronee("La note doit être 0 ou 1");
        }
        setScore(score);
    }
}
