package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class QCM extends Question implements Serializable {
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
