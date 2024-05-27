package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EpreuveClinique implements Serializable {
    private ObservationClinique observationClinique;
    private Test test;

    public EpreuveClinique(ObservationClinique observationClinique, Test test){
        this.observationClinique = observationClinique;
        this.test = test;
    }

    public EpreuveClinique(){
    }

    public ObservationClinique getObservationClinique(){
        return this.observationClinique;
    }

    public Test getTest(){
        return this.test;
    }

    public void setObservationClinique(ObservationClinique observationClinique){
        this.observationClinique = observationClinique;
    }

    public void setTest(Test test){
        this.test = test;
    }




}
