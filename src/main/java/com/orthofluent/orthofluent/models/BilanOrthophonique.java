package com.orthofluent.orthofluent.models;

public class BilanOrthophonique{
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
        return epreuveClinique;
    }
    public Diagnostique getDiagnostique(){
        return diagnostique;
    }
    public ProjetTherapeutique getProjetTherapeutique(){
        return projetTherapeutique;
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

}
