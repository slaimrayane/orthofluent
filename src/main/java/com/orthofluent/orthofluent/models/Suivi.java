package com.orthofluent.orthofluent.models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
public class Suivi extends RendezVous{
private String numDossierPatient;
private boolean presentiel;
private Set<Objectif> objectifs;

public Suivi(Duration duree, String observation, LocalDateTime date,String numDossierPatient, boolean presentiel, Set<Objectif> objectifs){
    super(Duration.ofMinutes(60), observation, date);
    this.numDossierPatient = numDossierPatient;
    this.presentiel = presentiel;
    this.objectifs = objectifs;
}
//je dois initialiser la liste des objectives a null
public Suivi(){
    setDuree(Duration.ofMinutes(60));
    
}

public String getNumDossierPatient() {
    return numDossierPatient;
}

public void setNumDossierPatient(String numDossierPatient ) {
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


