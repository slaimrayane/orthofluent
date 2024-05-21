package com.orthofluent.orthofluent.models;

public abstract class Test {
    private CompteRendu compteRendu;
    private String nom;
    private Capacite capacite;

    // constructeur
    public Test(String nom, Capacite capacite) {
        this.nom = nom;
        this.capacite = capacite;
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

    // Les methodes
    public abstract void LancerTest();

    public void AfficherTest() {

    };

}
