package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class QCU extends Question implements Serializable {
    private List<Proposition> propositionsList;

    public QCU(String enonce, List<Proposition> propositionsList, int note) {
        super(enonce, QuestionType.QCU);
        this.propositionsList = propositionsList;
        setNote(note);
    }
    public QCU(String enonce, List<Proposition> propositionsList) {
        super(enonce, QuestionType.QCU);
        this.propositionsList = propositionsList;
    }
    public QCU() {
        setQuestionType(QuestionType.QCU);
        propositionsList = new ArrayList<>();
    }

    public void setPropositionsList(List<Proposition> propositions) {
        this.propositionsList = propositions;
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
