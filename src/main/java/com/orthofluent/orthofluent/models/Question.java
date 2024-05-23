package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;

import java.io.Serializable;

public abstract class Question extends Evaluable implements Serializable {
    private String enonce;
    private QuestionType questionType;


    public Question(String enonce, QuestionType questionType) {
        this.enonce = enonce;
        this.questionType = questionType;
    }
    public Question() {
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType type) {
        this.questionType = type;
    }


    public void evaluer() {
        if (this.getReponse()) {
            setNote(1);
        } else {
            setNote(0);
        }
    }
}

