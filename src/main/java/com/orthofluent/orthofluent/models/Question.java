package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public abstract class Question implements Serializable {
    private String enonce;
    private QuestionType type;

    public Question(String enonce) {
        this.enonce = enonce;
        // this.type = type;
    }

    public abstract void ajouterQuestion();

    public void supprimerQuestion() {

    };

}
