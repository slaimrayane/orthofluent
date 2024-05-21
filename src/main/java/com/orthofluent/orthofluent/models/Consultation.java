package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
public abstract class Consultation extends RendezVous implements Serializable {
    //might change this to just patient but i am not sure
    //kaoutar if you pass here send a message we need to talk about this
    //also wesh hkayet attribut calendrier j'arrive pas a capter comment on va l'utiliser
    private String nom;
    private String prenom;
    private String age;
// Constructor
    public Consultation(Duration duree, String observation, LocalDateTime date,String nom, String prenom, String age){
        super(duree, observation, date);
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Consultation(){
        super();
    }
// Getters and Setters
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
