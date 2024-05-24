package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BilanOrthophonique implements Serializable {
    private List<EpreuveClinique> epreuvesCliniquesList;
    private Diagnostique diagnostique;
    private ProjetTherapeutique projetTherapeutique;
    // Constructor
    public BilanOrthophonique(List<EpreuveClinique> epreuvesCliniquesList, Diagnostique diagnostique, ProjetTherapeutique projetTherapeutique){
        this.epreuvesCliniquesList = epreuvesCliniquesList;
        this.diagnostique = diagnostique;
        this.projetTherapeutique = projetTherapeutique;
    }

    public BilanOrthophonique(){
        epreuvesCliniquesList = new ArrayList<>();
    }
    // Getters and Setters
    public List<EpreuveClinique> getEpreuvesCliniquesList(){
        return this.epreuvesCliniquesList;
    }

    public Diagnostique getDiagnostique(){
        return this.diagnostique;
    }

    public ProjetTherapeutique getProjetTherapeutique(){
        return this.projetTherapeutique;
    }

    public void setEpreuvesCliniquesList(List<EpreuveClinique> epreuvesCliniquesList){
        this.epreuvesCliniquesList = epreuvesCliniquesList;
    }

    public void setDiagnostique(Diagnostique diagnostique){
        this.diagnostique = diagnostique;
    }

    public void setProjetTherapeutique(ProjetTherapeutique projetTherapeutique){
        this.projetTherapeutique = projetTherapeutique;
    }

    public void addEpreuveClinique(EpreuveClinique epreuveClinique){
        epreuvesCliniquesList.add(epreuveClinique);
    }

    public void removeEpreuveClinique(EpreuveClinique epreuveClinique){
        epreuvesCliniquesList.remove(epreuveClinique);
    }

    public void clearEpreuveClinique(){
        epreuvesCliniquesList.clear();
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
        return this.epreuvesCliniquesList.equals(bilanOrthophonique.getEpreuvesCliniquesList()) && this.diagnostique.equals(bilanOrthophonique.getDiagnostique()) && this.projetTherapeutique.equals(bilanOrthophonique.getProjetTherapeutique());
    }

}
