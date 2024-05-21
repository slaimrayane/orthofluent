package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.Date;
public class PatientEnfant extends Patient implements Serializable {
    private String classEtude;
    private String telephoneparent;
// Constructor
    public PatientEnfant(String nom, int age, String addresse, String prenom, Date dateNaissance, String telephone, TypePatient typePatient, String classEtude, String telephoneparent) {
        super(nom, age, addresse, prenom, dateNaissance, telephone, typePatient);
        this.classEtude = classEtude;
        this.telephoneparent = telephoneparent;
    }

    public PatientEnfant() {
    }
// Getters and Setters
    public String getClassEtude() {
        return classEtude;
    }

    public void setClassEtude(String classEtude) {
        this.classEtude = classEtude;
    }

    public String getTelephoneparent() {
        return telephoneparent;
    }

    public void setTelephoneparent(String telephoneparent) {
        this.telephoneparent = telephoneparent;
    }

}
