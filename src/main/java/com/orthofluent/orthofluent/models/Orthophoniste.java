package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.ThematiqueAtelier;
import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;
import com.orthofluent.orthofluent.models.exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.Date;

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
    private Set<Exercise> exercisesSet;


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
        agenda = new Agenda();
        dossierPatientMap = new HashMap<>();
        patientCounter = 0;
        questionsAnamneseSet = new HashSet<>();
        questionsSet = new HashSet<>();
        exercisesSet = new HashSet<>();
    }

    public Orthophoniste() {
        dossierPatientMap=new HashMap<>();
        patientCounter=0;
        agenda = new Agenda();
        questionsAnamneseSet = new HashSet<>();
        questionsSet = new HashSet<>();
        exercisesSet = new HashSet<>();
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

    public Set<Exercise> getExercisesSet() {
        return exercisesSet;
    }

    public void setExercisesSet(Set<Exercise> exercisesSet) {
        this.exercisesSet = exercisesSet;
    }




    // Les methodes
    public void programmerConsultationAdulte(LocalDateTime dateTime, LocalTime heureDebut, String nom, String prenom, String age) throws ExceptionDateInvalide, ExceptionDatePrise {
        ConsultationAdulte rendezvous = new ConsultationAdulte();
        System.out.println("Programmer Consultation Adulte");

        rendezvous.setDate(dateTime);
        if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
            throw new ExceptionDateInvalide("La date de la consultation est invalide");
        }
        rendezvous.setNom(nom);
        rendezvous.setPrenom(prenom);
        rendezvous.setAge(age);
        rendezvous.setHeureDebut(heureDebut);

        if (!agenda.ajouterRendezVous(rendezvous)) {
            throw new ExceptionDatePrise("La date de la consultation est déjà prise");
        }

        System.out.println("Consultation programmée avec succès");
    }
    public void programmerConsultationEnfant(LocalDateTime dateTime, LocalTime heureDebut, String nom, String prenom, String age) throws ExceptionDateInvalide, ExceptionDatePrise {
        ConsultationEnfant rendezvous = new ConsultationEnfant();
        System.out.println("Programmer Consultation Enfant");

        rendezvous.setDate(dateTime);
        if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
            throw new ExceptionDateInvalide("La date de la consultation est invalide");
        }
        rendezvous.setNom(nom);
        rendezvous.setPrenom(prenom);
        rendezvous.setHeureDebut(heureDebut);
        rendezvous.setAge(age);

        if (!agenda.ajouterRendezVous(rendezvous)) {
            throw new ExceptionDatePrise("La date de la consultation est déjà prise");
        }

        System.out.println("Consultation programmée avec succès");
    }
    public void programmerSuivi(LocalDateTime dateTime, LocalTime heureDebut, String numDossierPatient, boolean isPresentiel) throws ExceptionDateInvalide, ExceptionDatePrise {
        Suivi rendezvous = new Suivi();
        System.out.println("Programmer Consultation Adulte");

        rendezvous.setDate(dateTime);
        if (rendezvous.getDate().isBefore(LocalDateTime.now())) {
            throw new ExceptionDateInvalide("La date de la consultation est invalide");
        }
        rendezvous.setNumDossierPatient(numDossierPatient);
        rendezvous.setPresentiel(isPresentiel);
        rendezvous.setHeureDebut(heureDebut);

        if (!agenda.ajouterRendezVous(rendezvous)) {
            throw new ExceptionDatePrise("La date de la consultation est déjà prise");
        }

        System.out.println("Consultation programmee avec succès");
    }

    public void programmerAtelier(LocalDateTime dateTime,LocalTime heureDebut ,List<String> numDossierPatients, ThematiqueAtelier theme) throws ExceptionDateInvalide, ExceptionDatePrise {
    Atelier atelier = new Atelier();
    System.out.println("Programmer Atelier");

    atelier.setDate(dateTime);
    if (atelier.getDate().isBefore(LocalDateTime.now())) {
        throw new ExceptionDateInvalide("La date de l'atelier est invalide");
    }
    atelier.setThematiqueAtelier(theme);

    atelier.setNumeroDossier(numDossierPatients);
    atelier.setHeureDebut(heureDebut);

    if (!agenda.ajouterRendezVous(atelier)) {
        throw new ExceptionDatePrise("La date de l'atelier est déjà prise");
    }

    System.out.println("Atelier programmé avec succès");
}

    public void supprimerRendezVous(Consultation consultation){
        agenda.supprimerRendezVous(consultation);
    }
    public void supprimerRendezVous(Suivi suivi){
        agenda.supprimerRendezVous(suivi);
    }

    public void supprimerRendezVous(Atelier atelier){
        agenda.supprimerRendezVous(atelier);
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
    public void modifierDossierPatient(PatientAdulte patientAdulte, String newNom, String newPrenom, int newAge, Date newDateNaissance, String newAdresse, String newTelephone, String newProfession, String newDiplome, String newTelephoneSecondaire) {
        // Iterate over the map to find and replace the patient
        for (Map.Entry<String, DossierPatient> entry : dossierPatientMap.entrySet()) {
            if (entry.getValue().getPatient().equals(patientAdulte)) {
                // Update patientAdulte object
                patientAdulte.setNom(newNom);
                patientAdulte.setPrenom(newPrenom);
                patientAdulte.setAge(newAge);
                patientAdulte.setDateNaissance(newDateNaissance);
                patientAdulte.setAddresse(newAdresse);
                patientAdulte.setTelephone(newTelephone);
                patientAdulte.setProfession(newProfession);
                patientAdulte.setDiplome(newDiplome);
                patientAdulte.setTelephoneSecondaire(newTelephoneSecondaire);
                entry.getValue().setPatient(patientAdulte);
                break;
            }
        }
    }

    public void modifierDossierPatient(PatientEnfant patientEnfant, String newNom, String newPrenom, int newAge, Date newDateNaissance, String newAdresse, String newTelephone, String newClasseEtude , String newTelephoneParent) {
        // Iterate over the map to find and replace the patient
        for (Map.Entry<String, DossierPatient> entry : dossierPatientMap.entrySet()) {
            if (entry.getValue().getPatient().equals(patientEnfant)) {
                // Update patientAdulte object
                patientEnfant.setNom(newNom);
                patientEnfant.setPrenom(newPrenom);
                patientEnfant.setAge(newAge);
                patientEnfant.setDateNaissance(newDateNaissance);
                patientEnfant.setAddresse(newAdresse);
                patientEnfant.setTelephone(newTelephone);
                patientEnfant.setClassEtude(newClasseEtude);
                patientEnfant.setTelephoneparent(newTelephoneParent);
                entry.getValue().setPatient(patientEnfant);
                break;
            }
        }
    }


    //Question anamnese
    public void ajouterQuestionAnamnese(QuestionAnamneseEnfant questionAnamnese) throws ExceptionQuestionAnamneseExistante{
        if (questionsAnamneseSet.contains(questionAnamnese)) {
            throw new ExceptionQuestionAnamneseExistante("Question already exists");
        } else {
            questionsAnamneseSet.add(questionAnamnese);
        }
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
    public void modifierQuestionAnamnese(QuestionAnamneseAdulte questionAnamnese, String newEnonce, TypeQuestionAnamnese newTypeQuestionAnamnese) {
        // Iterate over the set to find and replace the question
        for (QuestionAnamnese question : questionsAnamneseSet) {
            if (question.equals(questionAnamnese) && question instanceof QuestionAnamneseAdulte) {
                // Cast to QuestionAnamneseAdulte and update object
                QuestionAnamneseAdulte questionAnamneseAdulte = (QuestionAnamneseAdulte) question;
                questionAnamneseAdulte.setEnonce(newEnonce);
                questionAnamneseAdulte.setTypeQuestionAnamnese(newTypeQuestionAnamnese);
                break;
            }
        }
    }

    public void modifierQuestionAnamnese(QuestionAnamneseEnfant questionAnamnese, String newEnonce, TypeQuestionAnamnese newTypeQuestionAnamnese) {
        // Iterate over the set to find and replace the question
        for (QuestionAnamnese question : questionsAnamneseSet) {
            if (question.equals(questionAnamnese) && question instanceof QuestionAnamneseEnfant) {
                // Cast to QuestionAnamneseEnfant and update object
                QuestionAnamneseEnfant questionAnamneseEnfant = (QuestionAnamneseEnfant) question;
                questionAnamneseEnfant.setEnonce(newEnonce);
                questionAnamneseEnfant.setTypeQuestionAnamnese(newTypeQuestionAnamnese);
                break;
            }
        }
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

    public void ajouterQuestion(Question question) throws ExceptionQuestionExistante{
        if (questionsSet.contains(question)) {
            throw new ExceptionQuestionExistante("Question already exists");
        }else {
            questionsSet.add(question);
        }
    }
    public void ajouterQuestion(QCM question) throws ExceptionQuestionExistante{
        if (questionsSet.contains(question)) {
            throw new ExceptionQuestionExistante("Question already exists");
        }else {
            questionsSet.add(question);
        }
    }
    public void ajouterQuestion(QCU question) throws ExceptionQuestionExistante{
        if (questionsSet.contains(question)) {
            throw new ExceptionQuestionExistante("Question already exists");
        }else {
            questionsSet.add(question);
        }
    }
    public void ajouterQuestion(QuestionLibre question) throws ExceptionQuestionExistante{
        if (questionsSet.contains(question)) {
            throw new ExceptionQuestionExistante("Question already exists");
        }else {
            questionsSet.add(question);
        }
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

    public void modifierQuestion(QCM qcm, String newEnonce, int newNote, List<Proposition> newPropositions) {
        // Iterate over the set to find and replace the question
        for (Question question : questionsSet) {
            if (question.equals(qcm) && question instanceof QCM) {
                // Cast to QCM and update object
                QCM qcmQuestion = (QCM) question;
                qcmQuestion.setEnonce(newEnonce);
                qcmQuestion.setPropositionsList(newPropositions);
                qcmQuestion.setNote(newNote);
                break;
            }
        }
    }
    public void modifierQuestion(QuestionLibre questionLibre, String newEnonce, int newNote) {
        // Iterate over the set to find and replace the question
        for (Question question : questionsSet) {
            if (question.equals(questionLibre) && question instanceof QuestionLibre) {
                // Cast to QuestionLibre and update object
                QuestionLibre questionLibreQuestion = (QuestionLibre) question;
                questionLibreQuestion.setEnonce(newEnonce);
                questionLibreQuestion.setNote(newNote);
                break;
            }
        }
    }
    public void modifierQuestion(QCU qcu, String newEnonce, int newNote, List<Proposition> newPropositions) {
        // Iterate over the set to find and replace the question
        for (Question question : questionsSet) {
            if (question.equals(qcu) && question instanceof QCU) {
                // Cast to QCU and update object
                QCU qcuQuestion = (QCU) question;
                qcuQuestion.setEnonce(newEnonce);
                qcuQuestion.setPropositionsList(newPropositions);
                break;
            }
        }
    }

    public void ajouterExercice(Exercise exercise) throws ExceptionEvaluableExistant {
        if (exercisesSet.contains(exercise)) {
            throw new ExceptionEvaluableExistant("Exercise already exists");
        }else {
            exercisesSet.add(exercise);
        }
    }

    public void supprimerExercice(Exercise exercise){
        exercisesSet.remove(exercise);
    }

    public void modifierExercice(Exercise exercise, String newEnonce, int newNote, String newMateriel) {
        // Iterate over the set to find and replace the exercise
        for (Exercise exercice : exercisesSet) {
            if (exercice.equals(exercise)) {
                // Update Exercise object
                exercice.setEnonce(newEnonce);
                exercice.setNote(newNote);
                exercice.setMateriel(newMateriel);
                break;
            }
        }
    }

    public List<Exercise> getExercises(){
        return new ArrayList<>(exercisesSet);
    }

    public List<Atelier> getAteliers() {
        return agenda.getAtelierList();
    }
    public List<Consultation> getConsultations() {
        return agenda.getConsultationList();
    }
    public List<Suivi> getSuivis() {
        return agenda.getSuiviList();
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

