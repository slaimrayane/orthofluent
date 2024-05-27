package com.orthofluent.orthofluent.services;

import com.orthofluent.orthofluent.models.*;

public class DataManager {
    private static DataManager instance;
    private Orthophoniste orthophoniste;
    private Patient patient;
    private Question question;
    private QuestionAnamnese questionAnamnese;
    private Exercise exercise;

    private DataManager() {
        // Private constructor to prevent instantiation
    }
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void setOrthophoniste(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }

    public Orthophoniste getOrthophoniste() {
        return orthophoniste;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient(){
        return patient;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestionAnamnese(QuestionAnamnese questionAnamnese) {
        this.questionAnamnese = questionAnamnese;
    }
    public QuestionAnamnese getQuestionAnamnese() {
        return questionAnamnese;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public Exercise getExercise() {
        return exercise;
    }
}
