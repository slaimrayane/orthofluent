package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionScoreErronee;

public abstract class Evaluable {
    private int note;
    private int score;

    public abstract void evaluer(int score) throws ExceptionScoreErronee;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
