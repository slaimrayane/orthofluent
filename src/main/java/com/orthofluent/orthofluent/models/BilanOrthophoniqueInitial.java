package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public class BilanOrthophoniqueInitial extends BilanOrthophonique implements Serializable {
    private Anamnese anamnese;
// constructor
    public BilanOrthophoniqueInitial(Anamnese anamnese,EpreuveClinique epreuveClinique, Diagnostique diagnostique, ProjetTherapeutique projetTherapeutique){
        super(epreuveClinique, diagnostique, projetTherapeutique);
        this.anamnese = anamnese;
    }   
    public BilanOrthophoniqueInitial(){
    }
// getters and setters

    public Anamnese getAnamnese(){
        return this.anamnese;
    }

    public void setAnamnese(Anamnese anamnese){
        this.anamnese = anamnese;
    }

}
