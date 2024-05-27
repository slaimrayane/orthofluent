package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
public class Suivi extends RendezVous implements Serializable {
    private String numDossierPatient;
    private boolean presentiel;
    private Set<Objectif> objectifs;

    public Suivi(LocalDateTime date, LocalTime heureDebut, String numDossierPatient, boolean presentiel, Set<Objectif> objectifs) {
        super(Duration.ofMinutes(60), null, date, heureDebut);
        this.numDossierPatient = numDossierPatient;
        this.presentiel = presentiel;
        this.objectifs = objectifs;
    }

    //je dois initialiser la liste des objectives a null
    public Suivi() {
        setDuree(Duration.ofMinutes(60));

    }

    public String getNumDossierPatient() {

        return numDossierPatient;
    }

    public void setNumDossierPatient(String numDossierPatient) {
        this.numDossierPatient = numDossierPatient;
    }

    public boolean isPresentiel() {
        return presentiel;
    }

    public void setPresentiel(boolean presentiel) {
        this.presentiel = presentiel;
    }

    public Set<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(Set<Objectif> objectifs) {
        this.objectifs = objectifs;
    }
}



