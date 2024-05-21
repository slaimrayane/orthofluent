package com.orthofluent.orthofluent.models;

import java.util.List;
import java.util.ArrayList;

public class QCM extends Question {
    private List<Proposition> propositions = new ArrayList<>();

    public QCM(String enonce, List<Proposition> propositions) {
        super(enonce);
        this.propositions = propositions;
    }

    public void ajouterQuestion() {

    };

    public void supprimerQuestion() {

    };
}
