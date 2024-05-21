package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionDateInvalide;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDatePrise;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//hna dossierPatirnt w patient map yak?
public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String username;
    private String adresse;
    private int numTel;
    private String AdresseMail;
    private String motDePasse;
    private com.orthofluent.orthofluent.models.Agenda agenda;
    private Map<String,DossierPatient> dossierPatientMap;

  //  private Test test; // pcq kayan des methodes hna ta3 changement de questions ecq but i'm still not
                       // sure ida ysraw hna wla f la classe test >>TLFATLI!!



// Constructor
    public Orthophoniste(String nom, String prenom, String adresse, int numTel, String AdresseMail, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.username=nom+"_"+prenom;
        this.adresse = adresse;
        this.numTel = numTel;
        this.AdresseMail = AdresseMail;
        this.motDePasse = motDePasse;
        this.dossierPatientMap = new HashMap<>();
    }

    public Orthophoniste() {
        this.dossierPatientMap=new HashMap<>();
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
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getAdresseMail() {
        return AdresseMail;
    }

    public void setAdresseMail(String AdresseMail) {
        this.AdresseMail = AdresseMail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public com.orthofluent.orthofluent.models.Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(com.orthofluent.orthofluent.models.Agenda agenda) {
        this.agenda = agenda;
    }

    // Les methodes
        public void CreerPatient(DossierPatient dossierPatient) {
        this.dossierPatientMap.put(dossierPatient.getNumeroDossier(), dossierPatient);
        }

        public void ProgrammerConsultationAdulte() {
            ConsultationAdulte rendezvous = new ConsultationAdulte();
            System.out.println("Programmer Consultation Adulte");
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("veuillez indiquer la date de la consultation");
                String date = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(date); // Convert string to LocalDateTime
                rendezvous.setDate(dateTime);
                if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
                    throw new ExceptionDateInvalide("La date de la consultation est invalide");
                }
                System.out.println("veuillez indiquer le nom du patient");
                rendezvous.setNom(scanner.nextLine());
                System.out.println("veuillez indiquer le prenom du patient");
                rendezvous.setPrenom(scanner.nextLine());
                System.out.println("veuillez indiquer l'age du patient");
                rendezvous.setAge(scanner.nextLine()); 
                if (agenda.ajouterRendezVous(rendezvous)) {
                    System.out.println("Consultation programmée avec succès");
                } else {
                    throw new ExceptionDatePrise("La date de la consultation est déjà prise");
                }
                
            }catch (ExceptionDateInvalide e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la saisie de la date");
            }

        }
        public void ProgrammerConsultationEnfant() {
            ConsultationAdulte rendezvous = new ConsultationAdulte();
            System.out.println("Programmer Consultation Adulte");
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("veuillez indiquer la date de la consultation");
                String date = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(date); // Convert string to LocalDateTime
                rendezvous.setDate(dateTime);
                if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
                    throw new ExceptionDateInvalide("La date de la consultation est invalide");
                }
                System.out.println("veuillez indiquer le nom du patient");
                rendezvous.setNom(scanner.nextLine());
                System.out.println("veuillez indiquer le prenom du patient");
                rendezvous.setPrenom(scanner.nextLine());
                System.out.println("veuillez indiquer l'age du patient");
                rendezvous.setAge(scanner.nextLine()); 
                if (agenda.ajouterRendezVous(rendezvous)) {
                    System.out.println("Consultation programmée avec succès");
                } else {
                    throw new ExceptionDatePrise("La date de la consultation est déjà prise");
                }
                
            }catch (ExceptionDateInvalide e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la saisie de la date");
            }
        }
        public void ProgrammerSuivi(){
            Suivi rendezvous = new Suivi();
            System.out.println("Programmer Consultation Adulte");
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("veuillez indiquer la date de la consultation");
                String date = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(date); // Convert string to LocalDateTime
                rendezvous.setDate(dateTime);
                if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
                    throw new ExceptionDateInvalide("La date de la consultation est invalide");
                }
                System.out.println("veuillez indiquer le numero de dossier du patient");
                rendezvous.setNumDossierPatient(scanner.nextLine());
                System.out.println("Est-ce que la consultation est en presentiel? (oui/non)");
                String response = scanner.nextLine();
                boolean isPresentiel = response.equalsIgnoreCase("oui");
                rendezvous.setPresentiel(isPresentiel);


                if (agenda.ajouterRendezVous(rendezvous)) {
                    System.out.println("Consultation programmée avec succès");
                } else {
                    throw new ExceptionDatePrise("La date de la consultation est déjà prise");
                }
                
            }catch (ExceptionDateInvalide e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erreur lors de la saisie de la date");
            }
        }
        public void ProgrammerAtelier(){
        }

        public void ModifierPatient() {

        }

        public void creerQuestion() {

        }

        public void modifierQuestion() {

        }

        public void AfficherAgenda() {


        }

        public void ModifierAgenda() {

        }

        public void AfficherBoPatient() {

        }

        public void AfficherEvaluationPatient() {

        }

        public void ChercherTroublePatient() {

        }

        public void CreerDossier() {

        }

        public void CreerTest() {

        }

        public void ModifierTest() {

        }

        public void SupprimerTest() {

        }

        public void CreerAnamnese() {

        }

        public void ModifierAnamnese() {

        }

        public void SupprimerAnamnese() {

        }

        public void CreerExercice() {

        }

        public void ModifierExercice() {

        }

        public void SupprimerExercice() {

        }

        public void CreerBilan() {

        }

        public void ModifierBilan() {

        }

        public void SupprimerBilan() {

        }

        public void CreerQuestion() {

        }

        public void ModifierQuestion() {

        }

        public void SupprimerQuestion() {

        }

        public void CreerReponse() {

        }

        public void ModifierReponse() {

        }

        public void SupprimerReponse() {

        }

        public void afficherPatients(){

        }
// Interface
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Orthophoniste ortho = (Orthophoniste) obj;
        return (this.username==ortho.getUsername()); //If the objects are the same stance
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }


    @Override
    public String toString() {
        return "Orthophoniste [AdresseMail=" + AdresseMail + ", adresse=" + adresse + ", motDePasse=" + motDePasse + ", nom=" + nom + ", numTel=" + numTel + ", prenom=" + prenom + "]";
    }

        public static void saveOrthophoniste(Orthophoniste orthophoniste) {
        try {
            FileOutputStream fileOut = new FileOutputStream(orthophoniste.getUsername() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orthophoniste);
            out.close();
            fileOut.close();
            System.out.println("Profile saved successfully!");
        } catch (IOException e) {
            System.out.println("Failed to save profile: " + e.getMessage());
        }
    }


    public static Orthophoniste loadOrthophoniste(String username) {
        try {
            FileInputStream fileIn = new FileInputStream(username + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Orthophoniste orthophoniste = (Orthophoniste) in.readObject();
            in.close();
            fileIn.close();
            return orthophoniste;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load profile: " + e.getMessage());
            return null;
        }
    }



}

