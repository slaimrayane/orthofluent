package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.TypePatient;

import java.io.Serializable;
import java.util.Date;


public abstract class Patient implements Serializable {
	private String nom;
    private int age;
    private String addresse;
    private String prenom;
    private Date dateNaissance;

    private String telephone;
    private TypePatient typePatient;
//  Constructor
    public Patient(String nom, int age, String addresse, String prenom, Date dateNaissance,  String telephone, TypePatient typePatient) {
        this.nom = nom;
        this.age = age;
        this.addresse = addresse;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;

        this.telephone = telephone;
        this.typePatient = typePatient;
    }

    public Patient() {
    }
//  Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TypePatient getTypePatient() {
        return typePatient;
    }

    public void setTypePatient(TypePatient typePatient) {
        this.typePatient = typePatient;
    }
    
// Interface

@Override
public boolean equals(Object obj) {
    Patient patient = (Patient) obj;
    return (this.nom.equals(patient.nom) && this.prenom.equals(patient.prenom)); //If the objects are the same stance

}

@Override
public int hashCode() {
    return this.telephone.hashCode();
}


@Override
public String toString() {
    return "Patient{nom=" + this.nom + ", age=" + this.age + ", addresse=" + this.addresse + ", prenom=" + this.prenom + ", dateNaissance=" + this.dateNaissance + ", telephone=" + this.telephone + "}";   

}

    public boolean isEnfant() {
        if(typePatient==TypePatient.ENFANT){
            return true;
        }
        return false;
    }

    public boolean isAdulte() {
        if(typePatient==TypePatient.ADULTE){
            return true;
        }
        return false;
    }
}

