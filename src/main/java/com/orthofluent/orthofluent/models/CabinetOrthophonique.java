package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionCompteExistant;

import java.util.HashSet;
import java.util.Set;

public class CabinetOrthophonique{
    private Set<Orthophoniste> orthophonistes;
    private static CabinetOrthophonique instance = null;

    public CabinetOrthophonique(Set<Orthophoniste> orthophonistes) {
        this.orthophonistes = orthophonistes;
    }
    public CabinetOrthophonique(){
        this.orthophonistes = new HashSet<>();
    }

    public Set<Orthophoniste> getOrthophonistes() {
        return orthophonistes;
    }

    public void setOrthophonistes(Set<Orthophoniste> orthophonistes) {
        this.orthophonistes = orthophonistes;
    }

    public void addOrthophoniste(Orthophoniste orthophoniste){
        orthophonistes.add(orthophoniste);
    }

    public void removeOrthophoniste(Orthophoniste orthophoniste){
        orthophonistes.remove(orthophoniste);
    }

    public void afficherOrthophonistes(){
        for (Orthophoniste orthophoniste : orthophonistes) {
            System.out.println(orthophoniste.toString());
        }
    }

    public void afficherPatientsOrthophoniste(String nom, String prenom){
        Orthophoniste orthophoniste = chercherOrthophoniste(nom, prenom);
        if(orthophoniste != null){
            orthophoniste.afficherPatients();
        }
    }

    public void afficherPatientsOrthophonistes(){
        for (Orthophoniste orthophoniste : orthophonistes) {
            orthophoniste.afficherPatients();
        }
    }

    public void creerCompte(String nom, String prenom, String adresse, int numTel, String adresseMail, String motDePasse){

        Orthophoniste orthophoniste = new Orthophoniste(nom, prenom, adresse, numTel, adresseMail, motDePasse);
        try{
            if(chercherOrthophoniste(orthophoniste.getAdresseMail()) != null){
                throw new ExceptionCompteExistant("Un compte avec cette adresse mail existe deja");
            }
            orthophonistes.add(orthophoniste);
        }catch (ExceptionCompteExistant exceptionCompteExistant) {
            System.out.println(exceptionCompteExistant.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur lors de la creation du compte");
        } 
    }


    public void supprimerCompte(String nom){
        Orthophoniste orthophoniste = chercherOrthophoniste(nom);
        if(orthophoniste != null){
            orthophonistes.remove(orthophoniste);
        }
    }

    public boolean  authentifier(String email, String motDePasse){
        
        for (Orthophoniste orthophoniste : orthophonistes) {
            if(orthophoniste.getAdresseMail().equals(email) && orthophoniste.getMotDePasse().equals(motDePasse)){
                System.out.println("Authentification reussie");
                return true;
            }
        }
        System.out.println("Authentification echouee");
        return false;
    }
    public Orthophoniste chercherOrthophoniste(String email){
        for (Orthophoniste orthophoniste : orthophonistes) {
            if(orthophoniste.getAdresseMail().equals(email)){
                return orthophoniste;
            }
        }
        return null;
    }
    public Orthophoniste chercherOrthophoniste(String nom, String prenom){
        for (Orthophoniste orthophoniste : orthophonistes) {
            if(orthophoniste.getNom().equals(nom) && orthophoniste.getPrenom().equals(prenom)){
                return orthophoniste;
            }
        }
        return null;
    }
        public static CabinetOrthophonique getInstance() {
        if (instance == null) {
            instance = new CabinetOrthophonique();
        }
        return instance;
    }


}

