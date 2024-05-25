package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;

public class BilanOrthophoniqueInitial extends BilanOrthophonique implements Serializable {
    private Anamnese anamnese;

    public BilanOrthophoniqueInitial(List<EpreuveClinique> epreuvesCliniquesList, Diagnostique diagnostique, ProjetTherapeutique projetTherapeutique,Anamnese anamnese){
        super(epreuvesCliniquesList, diagnostique, projetTherapeutique);
        this.anamnese = anamnese;
    }

    public BilanOrthophoniqueInitial(){
    }

    public Anamnese getAnamnese(){
        return this.anamnese;
    }

    public void setAnamnese(Anamnese anamnese){
        this.anamnese = anamnese;
    }

}
