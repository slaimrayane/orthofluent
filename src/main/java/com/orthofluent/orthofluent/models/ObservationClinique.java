package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public class ObservationClinique implements Serializable, Comparable<ObservationClinique> {
    private String observationClinique;

    public ObservationClinique(String observationClinique){
        this.observationClinique = observationClinique;
    }

    public ObservationClinique(){
    }

    public String getObservationClinique(){
        return observationClinique;
    }

    public void setObservationClinique(String observationClinique){
        this.observationClinique = observationClinique;
    }

    public int compareTo(ObservationClinique observationClinique){
        return this.observationClinique.compareTo(observationClinique.getObservationClinique());
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
        ObservationClinique observationClinique = (ObservationClinique) obj;
        return this.observationClinique.equals(observationClinique.getObservationClinique());
    }

    public int hashCode(){
        return observationClinique.hashCode();
    }




}
