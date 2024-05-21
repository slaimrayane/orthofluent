package com.orthofluent.orthofluent.models;

public abstract class Question {
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
