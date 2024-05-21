package com.orthofluent.orthofluent.models;

import java.util.List;

public class Reponse {
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
