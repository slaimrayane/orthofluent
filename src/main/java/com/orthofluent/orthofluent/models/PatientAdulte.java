package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.TypePatient;

import java.io.Serializable;
import java.util.Date;
public class PatientAdulte extends Patient implements Serializable {
    private String profession;
    private String diplome;
    private String telephoneSecondaire;
// Constructor
    public PatientAdulte(String nom, int age, String addresse, String prenom, Date dateNaissance, String telephone, TypePatient typePatient, String profession, String diplome, String telephoneSecondaire) {
        super(nom, age, addresse, prenom, dateNaissance,telephone, typePatient);
        this.profession = profession;
        this.diplome = diplome;
        this.telephoneSecondaire = telephoneSecondaire;
    }

    public PatientAdulte() {
    }
// Getters and Setters
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getTelephoneSecondaire() {
        return telephoneSecondaire;
    }

    public void setTelephoneSecondaire(String telephoneSecondaire) {
        this.telephoneSecondaire = telephoneSecondaire;
    }


    
}
