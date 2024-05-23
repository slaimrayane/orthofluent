package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Capacite;

import java.io.Serializable;


//hadia hia
public abstract class Test implements Serializable {
    private CompteRendu compteRendu;
    private String nom;
    private Capacite capacite;

    // constructeur
    public Test(String nom, Capacite capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }
    public Test() {
    }

    // Getters/Setters
    public String getNom() {
        return nom;
    }

    public Capacite getCapacite() {
        return capacite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(Capacite capacite) {
        this.capacite = capacite;
    }

    public void setCompteRendu(CompteRendu compteRendu) {
        this.compteRendu = compteRendu;
    }

    public CompteRendu getCompteRendu() {
        return compteRendu;
    }


    // Les methodes
    public abstract void evaluerTest(String conclusion, String remarque);


}
