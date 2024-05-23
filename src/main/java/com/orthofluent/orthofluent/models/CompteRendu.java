package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public class CompteRendu implements Serializable {
    private String conclusion;
    private String remarque;
    private int score;

    public CompteRendu(String conclusion, String remarque, int score) {
        this.conclusion = conclusion;
        this.remarque = remarque;
        this.score = score;
    }
    public CompteRendu(){
        score = 0;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getRemarque() {
        return remarque;
    }
    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }



}
//score ikoun frl compte rendu
