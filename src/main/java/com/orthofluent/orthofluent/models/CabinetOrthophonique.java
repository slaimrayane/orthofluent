package com.orthofluent.orthofluent.models;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CabinetOrthophonique{
    private Set<Orthophoniste> orthophonistes;

    public CabinetOrthophonique(Set<Orthophoniste> orthophonistes) {
        this.orthophonistes = orthophonistes;
    }
    public CabinetOrthophonique(){
        this.orthophonistes = new HashSet<Orthophoniste>();
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
            System.out.println(orthophoniste);
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

    public void creerCompte(){

        Orthophoniste orthophoniste = new Orthophoniste();
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Entrez le nom de l'orthophoniste");
            orthophoniste.setNom(scanner.nextLine());
            System.out.println("Entrez le prenom de l'orthophoniste");
            orthophoniste.setPrenom(scanner.nextLine());
            System.out.println("Entrez l'adresse de l'orthophoniste");
            orthophoniste.setAdresse(scanner.nextLine());
            System.out.println("Entrez le numero de telephone de l'orthophoniste");
            orthophoniste.setNumTel(scanner.nextInt());
            System.out.println("Entrez l'adresse mail de l'orthophoniste");
            orthophoniste.setAdresseMail(scanner.nextLine());
            System.out.println("Entrez le mot de passe de l'orthophoniste");
            orthophoniste.setMotDePasse(scanner.nextLine());
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

}
class ExceptionCompteExistant extends Exception{
    public ExceptionCompteExistant(String message) {
        super(message);
    }
}

