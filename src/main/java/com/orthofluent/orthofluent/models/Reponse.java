package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;

public class Reponse implements Serializable {
    private List<Proposition> propositions;

    public Reponse(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    
}
