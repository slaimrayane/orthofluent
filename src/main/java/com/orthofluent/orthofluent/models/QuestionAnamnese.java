package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;

import java.io.Serializable;
import java.util.Objects;

public abstract class QuestionAnamnese implements Serializable , Comparable<QuestionAnamnese> {
    private TypeQuestionAnamnese typeQuestionAnamnese;
    private String enonce;
    private String reponse;

    public QuestionAnamnese(TypeQuestionAnamnese typeQuestionAnamnese, String enonce, String reponse) {
        this.typeQuestionAnamnese = typeQuestionAnamnese;
        this.enonce = enonce;
        this.reponse = reponse;
    }
    public QuestionAnamnese(TypeQuestionAnamnese typeQuestionAnamnese, String enonce) {
        this.typeQuestionAnamnese = typeQuestionAnamnese;
        this.enonce = enonce;
    }

    public TypeQuestionAnamnese getTypeQuestionAnamnese() {
        return typeQuestionAnamnese;
    }

    public String getEnonce() {
        return enonce;
    }

    public String getReponse() {
        return reponse;
    }

    public void setTypeQuestionAnamnese(TypeQuestionAnamnese typeQuestionAnamnese) {
        this.typeQuestionAnamnese = typeQuestionAnamnese;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionAnamnese other = (QuestionAnamnese) obj;
        if (this.typeQuestionAnamnese != other.typeQuestionAnamnese) {
            return false;
        }
        return Objects.equals(this.enonce, other.enonce);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.typeQuestionAnamnese != null ? this.typeQuestionAnamnese.hashCode() : 0);
        hash = 59 * hash + (this.enonce != null ? this.enonce.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(QuestionAnamnese questionAnamnese) {
        int enonceComparison = this.enonce.compareTo(questionAnamnese.enonce);
        if (enonceComparison != 0) {
            return enonceComparison;
        }
        return this.typeQuestionAnamnese.compareTo(questionAnamnese.typeQuestionAnamnese);
    }
}
