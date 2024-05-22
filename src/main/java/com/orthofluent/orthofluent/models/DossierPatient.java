package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;
public class DossierPatient implements Comparable<DossierPatient> , Serializable {
    private Patient patient;
    private String numeroDossier;
    private List<BilanOrthophonique> bilansOrthophoniques;
    private List<RendezVous> rendezVous;
    private List<FicheSuivi> fichesSuivi;

// CONSTRUCTOR
    public DossierPatient(Patient patient, String numeroDossier, List<BilanOrthophonique> bilansOrthophoniques, List<RendezVous> rendezVous, List<FicheSuivi> fichesSuivi){
        this.patient = patient;
        this.numeroDossier = numeroDossier;
        this.bilansOrthophoniques = bilansOrthophoniques;
        this.rendezVous = rendezVous;
        this.fichesSuivi = fichesSuivi;
    }
    
    public DossierPatient(Patient patient, String numeroDossier){
        this.patient = patient;
        this.numeroDossier = numeroDossier;
    }
    public DossierPatient(){
    }
// GETTERS AND SETTERS
    public Patient getPatient(){
        return this.patient;
    }

    public String getNumeroDossier(){
        return this.numeroDossier;
    }

    public List<BilanOrthophonique> getBilansOrthophoniques(){
        return this.bilansOrthophoniques;
    }

    public List<RendezVous> getRendezVous(){
        return this.rendezVous;
    }

    public List<FicheSuivi> getFichesSuivi(){
        return this.fichesSuivi;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void setNumeroDossier(String numeroDossier){
        this.numeroDossier = numeroDossier;
    }

    public void setBilansOrthophoniques(List<BilanOrthophonique> bilansOrthophoniques){
        this.bilansOrthophoniques = bilansOrthophoniques;
    }

    public void setRendezVous(List<RendezVous> rendezVous){
        this.rendezVous = rendezVous;
    }

    public void setFichesSuivi(List<FicheSuivi> fichesSuivi){
        this.fichesSuivi = fichesSuivi;
    }
// ADD, REMOVE AND CLEAR METHODS
    public void addBilanOrthophonique(BilanOrthophonique bilanOrthophonique){
        this.bilansOrthophoniques.add(bilanOrthophonique);
    }

    public void addRendezVous(RendezVous rendezVous){
        this.rendezVous.add(rendezVous);
    }

    public void addFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuivi.add(ficheSuivi);
    }

    public void removeBilanOrthophonique(BilanOrthophonique bilanOrthophonique){
        this.bilansOrthophoniques.remove(bilanOrthophonique);
    }

    public void removeRendezVous(RendezVous rendezVous){
        this.rendezVous.remove(rendezVous);
    }

    public void removeFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuivi.remove(ficheSuivi);
    }

    public void removeBilanOrthophonique(int index){
        this.bilansOrthophoniques.remove(index);
    }

    public void removeRendezVous(int index){
        this.rendezVous.remove(index);
    }

    public void removeFicheSuivi(int index){
        this.fichesSuivi.remove(index);
    }

    public void clearBilanOrthophoniques(){
        this.bilansOrthophoniques.clear();
    }

    public void clearRendezVous(){
        this.rendezVous.clear();
    }

    public void clearFichesSuivi(){
        this.fichesSuivi.clear();
    }



    @Override
    public String toString(){
        return "DossierPatient{patient=" + this.patient + ", numeroDossier=" + this.numeroDossier + ", bilansOrthophoniques=" + this.bilansOrthophoniques + ", rendezVous=" + this.rendezVous + ", fichesSuivi=" + this.fichesSuivi + "}";
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
