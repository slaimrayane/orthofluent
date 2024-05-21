package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;

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
