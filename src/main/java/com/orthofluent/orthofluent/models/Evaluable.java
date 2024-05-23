package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionScoreErronee;

public abstract class Evaluable {
    private int note;

    public abstract void evaluer(int note) throws ExceptionScoreErronee;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }


}
