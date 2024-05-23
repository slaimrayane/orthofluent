package com.orthofluent.orthofluent.models;

import java.io.Serializable;
//cette classe represente les organe de la reponse
public class Proposition implements Serializable {
    private String propositionText;

    
    public Proposition(String propositionText) {
        this.propositionText = propositionText;
    }
    public Proposition() {
    }
    
    public String getPropositionText() {
        return propositionText;
    }
    public void setPropositionText(String propositionText) {
        this.propositionText = propositionText;
    }
    

}