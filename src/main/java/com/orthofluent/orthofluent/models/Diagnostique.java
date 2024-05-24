package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Trouble;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Diagnostique implements Serializable {

    private Map<String, Trouble> diagnostiqueMap;

    public Diagnostique(Map<String, Trouble> diagnostiqueMap){
        this.diagnostiqueMap = diagnostiqueMap;
    }

    public Diagnostique(){
        diagnostiqueMap = new HashMap<>();
    }

    public Map<String, Trouble> getDiagnostiqueMap(){
        return diagnostiqueMap;
    }

    public void setDiagnostiqueMap(Map<String, Trouble> diagnostiqueMap){
        this.diagnostiqueMap = diagnostiqueMap;
    }

    public void addDiagnostique(String trouble, Trouble troubleType){
        diagnostiqueMap.put(trouble, troubleType);
    }

    public void removeDiagnostique(String trouble){
        diagnostiqueMap.remove(trouble);
    }

    public void clearDiagnostique(){
        diagnostiqueMap.clear();
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
        Diagnostique diagnostique = (Diagnostique) obj;
        return this.diagnostiqueMap.equals(diagnostique.getDiagnostiqueMap());
    }

    public int hashCode(){
        return diagnostiqueMap.hashCode();
    }




    
    
}
