package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class QCU extends Question implements Serializable {
    private List<Proposition> propositions;

    public QCU(String enonce, List<Proposition> propositions) {
        super(enonce);
        this.propositions = propositions;
    }

    public void ajouterQuestion() {

    };

    public void supprimerQuestion() {

    };
}
