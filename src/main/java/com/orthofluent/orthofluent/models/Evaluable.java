package com.orthofluent.orthofluent.models;

public abstract class Evaluable {
    private int note;
    private Boolean reponse;

    public abstract void evaluer();

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    public Boolean getReponse() {
        return reponse;
    }
    public void setReponse(Boolean reponse) {
        this.reponse = reponse;
    }

}
