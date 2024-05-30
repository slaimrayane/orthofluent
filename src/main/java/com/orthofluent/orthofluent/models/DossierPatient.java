package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DossierPatient implements Comparable<DossierPatient> , Serializable {
    private Patient patient;
    private String numeroDossier;
    private Set<BilanOrthophonique> bilansOrthophoniquesSet;
    private Set<RendezVous> rendezVousSet;
    private Set<FicheSuivi> fichesSuiviSet;

    // CONSTRUCTOR
    public DossierPatient(Patient patient, String numeroDossier, Set<BilanOrthophonique> bilansOrthophoniquesSet, Set<RendezVous> rendezVousSet, Set<FicheSuivi> fichesSuiviSet){
        this.patient = patient;
        this.numeroDossier = numeroDossier;
        this.bilansOrthophoniquesSet = bilansOrthophoniquesSet;
        this.rendezVousSet = rendezVousSet;
        this.fichesSuiviSet = fichesSuiviSet;
    }
    
    public DossierPatient(Patient patient, String numeroDossier){
        this.patient = patient;
        this.numeroDossier = numeroDossier;
        bilansOrthophoniquesSet= new HashSet<>();
        rendezVousSet= new HashSet<>();
        fichesSuiviSet= new HashSet<>();

    }
    public DossierPatient(){
        bilansOrthophoniquesSet= new HashSet<>();
        rendezVousSet= new HashSet<>();
        fichesSuiviSet= new HashSet<>();
    }

    // GETTERS AND SETTERS
    public Patient getPatient(){
        return this.patient;
    }

    public String getNumeroDossier(){
        return this.numeroDossier;
    }

    public Set<BilanOrthophonique> getBilansOrthophoniquesSet(){
        return this.bilansOrthophoniquesSet;
    }

    public Set<RendezVous> getRendezVousSet(){
        return this.rendezVousSet;
    }

    public Set<FicheSuivi> getFichesSuiviSet(){
        return this.fichesSuiviSet;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void setNumeroDossier(String numeroDossier){
        this.numeroDossier = numeroDossier;
    }

    public void setBilansOrthophoniquesSet(Set<BilanOrthophonique> bilansOrthophoniquesSet){
        this.bilansOrthophoniquesSet = bilansOrthophoniquesSet;
    }

    public void setRendezVousSet(Set<RendezVous> rendezVousSet){
        this.rendezVousSet = rendezVousSet;
    }

    public void setFichesSuiviSet(Set<FicheSuivi> fichesSuiviSet){
        this.fichesSuiviSet = fichesSuiviSet;
    }

    // ADD, REMOVE AND CLEAR METHODS
    public void ajouterBilanOrthophonique(BilanOrthophonique bilanOrthophonique){
        this.bilansOrthophoniquesSet.add(bilanOrthophonique);
    }

    public void supprimerBilanOrthophonique(BilanOrthophonique bilanOrthophonique){
        this.bilansOrthophoniquesSet.remove(bilanOrthophonique);
    }

    public void ajouterRendezVous(RendezVous rendezVous){
        this.rendezVousSet.add(rendezVous);
    }

    public void supprimerRendezVous(RendezVous rendezVous){
        this.rendezVousSet.remove(rendezVous);
    }

    public void ajouterFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuiviSet.add(ficheSuivi);
    }

    public void supprimerFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuiviSet.remove(ficheSuivi);
    }

    public void clearBilansOrthophoniques(){
        this.bilansOrthophoniquesSet.clear();
    }

    public void clearRendezVous(){
        this.rendezVousSet.clear();
    }

    public void clearFichesSuivi(){
        this.fichesSuiviSet.clear();
    }
    public void clearAll(){
        this.bilansOrthophoniquesSet.clear();
        this.rendezVousSet.clear();
        this.fichesSuiviSet.clear();
    }

    public List<BilanOrthophonique> getBilansOrthophoniques(){
        return new ArrayList<>(bilansOrthophoniquesSet);
    }

    public List<RendezVous> getRendezVous(){
        return new ArrayList<>(rendezVousSet);
    }

    public List<FicheSuivi> getFichesSuivi(){
        return new ArrayList<>(fichesSuiviSet);
    }
    public List<QuestionAnamnese> getQuestionOrthophoniqueList(){
        for(BilanOrthophonique bilan : bilansOrthophoniquesSet){
            if(bilan instanceof BilanOrthophoniqueInitial){
                return ((BilanOrthophoniqueInitial) bilan).getQuestionAnamneseList();
            }
        }
        return null; // or return new ArrayList<>(); if you prefer to return an empty list
    }

    public List<EpreuveClinique> getEpreuveCliniqueList(){
        List<EpreuveClinique> epreuvesCliniquesLists = new ArrayList<>();
        for(BilanOrthophonique bilan : bilansOrthophoniquesSet){
            epreuvesCliniquesLists.add(bilan.getEpreuveClinique());
        }
        return epreuvesCliniquesLists; // or return new ArrayList<>(); if you prefer to return an empty list
    }



    // TOSTRING, EQUALS, HASHCODE AND COMPARETO METHODS
    @Override
    public String toString(){
        return "DossierPatient{patient=" + this.patient + ", numeroDossier=" + this.numeroDossier +  "}";
    }

    @Override
    public int compareTo(DossierPatient dossierPatient){
        return this.numeroDossier.compareTo(dossierPatient.numeroDossier);
    }

    @Override
    public boolean equals(Object obj){
        DossierPatient dossierPatient = (DossierPatient) obj;
        return this.numeroDossier.equals(dossierPatient.numeroDossier);
    }

    @Override
    public int hashCode(){
        return this.numeroDossier.hashCode();
    }


    public boolean isEnfant() {
        return this.patient.isEnfant();
    }

    public boolean isAdulte() {
        return this.patient.isAdulte();
    }
}
