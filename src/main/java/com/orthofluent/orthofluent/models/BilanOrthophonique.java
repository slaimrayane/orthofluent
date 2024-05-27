package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public class BilanOrthophonique implements Serializable {
    private EpreuveClinique epreuveClinique;
    private Diagnostique diagnostique;
    private ProjetTherapeutique projetTherapeutique;
    // Constructor
    public BilanOrthophonique(EpreuveClinique epreuveClinique, Diagnostique diagnostique, ProjetTherapeutique projetTherapeutique){
        this.epreuveClinique = epreuveClinique;
        this.diagnostique = diagnostique;
        this.projetTherapeutique = projetTherapeutique;
    }

    public BilanOrthophonique(){
    }
    // Getters and Setters
    public EpreuveClinique getEpreuveClinique(){
        return this.epreuveClinique;
    }

    public Diagnostique getDiagnostique(){
        return this.diagnostique;
    }

    public ProjetTherapeutique getProjetTherapeutique(){
        return this.projetTherapeutique;
    }

    public void setEpreuveClinique(EpreuveClinique epreuveClinique){
        this.epreuveClinique = epreuveClinique;
    }

    public void setDiagnostique(Diagnostique diagnostique){
        this.diagnostique = diagnostique;
    }

    public void setProjetTherapeutique(ProjetTherapeutique projetTherapeutique){
        this.projetTherapeutique = projetTherapeutique;
    }


public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj.getClass() != getClass()){
            return false;
        }
        BilanOrthophonique bilanOrthophonique = (BilanOrthophonique) obj;
        return this.epreuveClinique.equals(bilanOrthophonique.getEpreuveClinique()) && this.diagnostique.equals(bilanOrthophonique.getDiagnostique()) && this.projetTherapeutique.equals(bilanOrthophonique.getProjetTherapeutique());
    }

}
