package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.exceptions.ExceptionDateInvalide;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDatePrise;
import com.orthofluent.orthofluent.models.exceptions.ExceptionDossierExistant;
import com.orthofluent.orthofluent.models.exceptions.ExceptionQuestionAnamneseExistante;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

//hna dossierPatirnt w patient map yak?
public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String username;
    private String adresse;
    private int numTel;
    private String AdresseMail;
    private String motDePasse;
    private int patientCounter;
    private com.orthofluent.orthofluent.models.Agenda agenda;
    private Map<String,DossierPatient> dossierPatientMap;
    private Set<QuestionAnamnese> questionsAnamneseSet;
    private Set<Question> questionsSet;


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
        dossierPatientMap = new HashMap<>();
        patientCounter = 0;
        questionsAnamneseSet = new HashSet<>();
        questionsSet = new HashSet<>();
    }

    public Orthophoniste() {
        dossierPatientMap=new HashMap<>();
        patientCounter=0;
        questionsAnamneseSet = new HashSet<>();
        questionsSet = new HashSet<>();
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

    public int getPatientCounter() {
        return patientCounter;
    }
    public int setPatientCounter(int patientCounter) {
        return this.patientCounter=patientCounter;
    }
    public void incrementPatientCounter(){
        patientCounter++;
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

    public Map<String, DossierPatient> getDossierPatientMap() {
        return dossierPatientMap;
    }

    public void setDossierPatientMap(Map<String, DossierPatient> dossierPatientMap) {
        this.dossierPatientMap = dossierPatientMap;
    }

    public Set<QuestionAnamnese> getQuestionsAnamneseSet() {
        return questionsAnamneseSet;
    }

    public void setQuestionsAnamneseSet(Set<QuestionAnamnese> questionsAnamneseSet) {
        this.questionsAnamneseSet = questionsAnamneseSet;
    }

    public Set<Question> getQuestionsSet() {
        return questionsSet;
    }

    public void setQuestionsSet(Set<Question> questionsSet) {
        this.questionsSet = questionsSet;
    }



    // Les methodes
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
                    System.out.println("Consultation programmee avec succès");
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
    //a revoir apres la logique de la BO
    public void initialiserPatient(PatientEnfant patientEnfant)throws ExceptionDossierExistant{
        DossierPatient dossierPatient = new DossierPatient(patientEnfant,String.valueOf(patientCounter++));
        ajouterDossierPatient(dossierPatient);
    }

    public void initialiserPatient(PatientAdulte patientAdulte) throws ExceptionDossierExistant{
        DossierPatient dossierPatient = new DossierPatient(patientAdulte,String.valueOf(patientCounter++));
        ajouterDossierPatient(dossierPatient);
    }


    public void ajouterDossierPatient(DossierPatient dossierPatient) throws ExceptionDossierExistant {
    if (dossierPatientMap.containsKey(dossierPatient.getNumeroDossier())) {
        throw new ExceptionDossierExistant("Le dossier patient existe déjà");
    }
        dossierPatientMap.put(dossierPatient.getNumeroDossier(), dossierPatient);

}
    public List<PatientEnfant> getPatientsEnfants(){
            return dossierPatientMap.values().stream().filter(DossierPatient::isEnfant).map(dossier -> (PatientEnfant) dossier.getPatient()).collect(Collectors.toList());
    }
    public List<PatientAdulte> getPatientsAdultes(){
        return dossierPatientMap.values().stream().filter(DossierPatient::isAdulte).map(dossier -> (PatientAdulte) dossier.getPatient()).collect(Collectors.toList());
    }

    public void supprimerDossierPatient(String numeroDossier){
        dossierPatientMap.remove(numeroDossier);
    }

    public void supprimerDossierPatient(DossierPatient dossierPatient){
        dossierPatientMap.remove(dossierPatient.getNumeroDossier());
    }

    public void supprimerDossierPatient(Patient patient){
        dossierPatientMap.values().removeIf(dossierPatient -> dossierPatient.getPatient().equals(patient));
    }

    public void supprimerDossierPatient(PatientEnfant patientEnfant){
        dossierPatientMap.values().removeIf(dossierPatient -> dossierPatient.getPatient().equals(patientEnfant));
    }

        public void supprimerDossierPatient(PatientAdulte patientAdulte) {
            dossierPatientMap.values().removeIf(dossierPatient -> dossierPatient.getPatient().equals(patientAdulte));
        }
    public void modifierPatient() {

    }


    //Question anamnese
    public void ajouterQuestionAnamnese(QuestionAnamneseEnfant questionAnamnese){
        questionsAnamneseSet.add(questionAnamnese);
    }
    public void ajouterQuestionAnamnese(QuestionAnamneseAdulte questionAnamnese) throws ExceptionQuestionAnamneseExistante {
        if (questionsAnamneseSet.contains(questionAnamnese)) {
            throw new ExceptionQuestionAnamneseExistante("Question already exists");
        } else {
            questionsAnamneseSet.add(questionAnamnese);
        }
    }

    public void supprimerQuestionAnamnese(QuestionAnamneseAdulte questionAnamnese){
        questionsAnamneseSet.remove(questionAnamnese);
    }
    public void supprimerQuestionAnamnese(QuestionAnamneseEnfant questionAnamnese){
        questionsAnamneseSet.remove(questionAnamnese);
    }
    public List<QuestionAnamneseAdulte> getQuestionsAnamneseAdulte(){
           return questionsAnamneseSet.stream().filter(QuestionAnamneseAdulte.class::isInstance).map(QuestionAnamneseAdulte.class::cast).collect(Collectors.toList());
    }
    public List<QuestionAnamneseEnfant> getQuestionsAnamneseEnfant(){
           return questionsAnamneseSet.stream().filter(QuestionAnamneseEnfant.class::isInstance).map(QuestionAnamneseEnfant.class::cast).collect(Collectors.toList());
    }
    public List<QuestionAnamnese> getQuestionsAnamnese(){
        return new ArrayList<>(questionsAnamneseSet);
    }

    public void ajouterQuestion(Question question){
        questionsSet.add(question);
    }
    public void ajouterQuestion(QCM question){
        questionsSet.add(question);
    }
    public void ajouterQuestion(QCU question){
        questionsSet.add(question);
    }
    public void ajouterQuestion(QuestionLibre question){
        questionsSet.add(question);
    }

    public void supprimerQuestion(Question question){
        questionsSet.remove(question);
    }
    public void supprimerQuestion(QCM question){
        questionsSet.remove(question);
    }
    public void supprimerQuestion(QCU question){
        questionsSet.remove(question);
    }
    public void supprimerQuestion(QuestionLibre question){
        questionsSet.remove(question);
    }

    public List<Question> getQuestions(){
        return new ArrayList<>(questionsSet);
    }
    public List<QCM> getQCM(){
        return questionsSet.stream().filter(QCM.class::isInstance).map(QCM.class::cast).collect(Collectors.toList());
    }
    public List<QCU> getQCU(){
        return questionsSet.stream().filter(QCU.class::isInstance).map(QCU.class::cast).collect(Collectors.toList());
    }
    public List<QuestionLibre> getQuestionsLibres() {
        return questionsSet.stream().filter(QuestionLibre.class::isInstance).map(QuestionLibre.class::cast).collect(Collectors.toList());
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

