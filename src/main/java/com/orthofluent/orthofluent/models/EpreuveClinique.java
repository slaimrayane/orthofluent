package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EpreuveClinique implements Serializable {
    private Set<ObservationClinique> observationCliniqueSet;
    private Set<Test> testSet;

    public EpreuveClinique(Set<ObservationClinique> observationCliniqueSet, Set<Test> testSet){
        this.observationCliniqueSet = observationCliniqueSet;
        this.testSet = testSet;
    }

    public EpreuveClinique(){
        observationCliniqueSet = new HashSet<>();
        testSet = new HashSet<>();
    }

    public Set<ObservationClinique> getObservationCliniqueSet(){
        return observationCliniqueSet;
    }

    public Set<Test> getTestSet(){
        return testSet;
    }

    public void setObservationCliniqueSet(Set<ObservationClinique> observationCliniqueSet){
        this.observationCliniqueSet = observationCliniqueSet;
    }

    public void setTestSet(Set<Test> testSet){
        this.testSet = testSet;
    }

    public void addObservationClinique(ObservationClinique observationClinique){
        observationCliniqueSet.add(observationClinique);
    }

    public void addTest(Test test){
        testSet.add(test);
    }

    public void removeObservationClinique(ObservationClinique observationClinique){
        observationCliniqueSet.remove(observationClinique);
    }

    public void removeTest(Test test){
        testSet.remove(test);
    }

    public void clearObservationClinique(){
        observationCliniqueSet.clear();
    }

    public void clearTest(){
        testSet.clear();
    }

    public List<ObservationClinique> getObservationCliniqueList(){
        return new ArrayList<>(observationCliniqueSet);
    }

    public List<Test> getTestList(){
        return new ArrayList<>(testSet);
    }



}
