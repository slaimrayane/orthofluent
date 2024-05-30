package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Capacite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestExercise extends Test implements  Serializable {
    private List<Exercise> exercicesList;


    // constructeur
    public TestExercise(String nom, Capacite capacite, List<Exercise> exercicesList) {
        super(nom, capacite);
        this.exercicesList = exercicesList;
    }
    public TestExercise() {
        super();
        exercicesList = new ArrayList<>();
    }

    // Getters/Setters
    public List<Exercise> getExercicesList() {
        return exercicesList;
    }

    public void setExercicesList(List<Exercise> exercicesList) {
        this.exercicesList = exercicesList;
    }

    public void ajouterExercice(Exercise exercice){
        exercicesList.add(exercice);
    }

    public void supprimerExercice(Exercise exercice){
        exercicesList.remove(exercice);
    }

    public List<Exercise> getExercices(){
        return new ArrayList<>(exercicesList);
    }

    //redifine equals and hashcode methods
    // Les methodes
    @Override
    public void evaluerTest(String conclusion, String remarque) {
        HashMap<Exercise, List<Integer>> exerciseScores = new HashMap<>();
        for (Exercise exercise : exercicesList) {
            getCompteRendu().ajouterScore(exercise, exercise.getNote());
            if (!exerciseScores.containsKey(exercise)) {
                exerciseScores.put(exercise, new ArrayList<>());
            }
            exerciseScores.get(exercise).add(exercise.getNote());
        }

        int totalScore = 0;
        for (List<Integer> scores : exerciseScores.values()) {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            totalScore += sum /scores.size();
        }

        getCompteRendu().setScore(totalScore);
        getCompteRendu().setConclusion(conclusion);
        getCompteRendu().setRemarque(remarque);
    }



    public void EvaluerExercice(Exercise exercise, int note) {
        for (Exercise e : exercicesList){
            if (e.equals(exercise)){
                e.setNote(note);
            }
        }
    }
}
