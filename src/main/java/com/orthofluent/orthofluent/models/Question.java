package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;
import com.orthofluent.orthofluent.models.exceptions.ExceptionScoreErronee;

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

    public void evaluer(int note) throws ExceptionScoreErronee {
        if (note < 0 || note > 10) {
            throw new ExceptionScoreErronee("La note doit être 0 ou 1");
        }
        setNote(note);
    }
}

