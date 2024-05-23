package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import com.orthofluent.orthofluent.models.enumerations.QuestionType;

public class QCM extends Question implements Serializable {
    private List<Proposition> propositionsList;

    public QCM(String enonce, List<Proposition> propositionsList) {
        super(enonce, QuestionType.QCM);
        this.propositionsList = propositionsList;

    }
    public QCM() {
        setQuestionType(QuestionType.QCM);
        propositionsList = new ArrayList<>();
    }

    public void setPropositionsList(List<Proposition> propositionsList) {
        this.propositionsList = propositionsList;
    }

    public List<Proposition> getPropositionsList() {
        return propositionsList;
    }

    public void ajouterProposition(Proposition proposition) {
        propositionsList.add(proposition);
    }

    public void supprimerProposition(Proposition proposition) {
        propositionsList.remove(proposition);
    }

}
