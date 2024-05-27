package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompteRendu implements Serializable {
    private String conclusion;
    private String remarque;
    private int score;
    private HashMap<Evaluable, List<Integer>> exerciseScoresMap;

    public CompteRendu(String conclusion, String remarque, int score, HashMap<Evaluable, List<Integer>> exerciseScoresMap) {
        this.conclusion = conclusion;
        this.remarque = remarque;
        this.score = score;
        this.exerciseScoresMap =  exerciseScoresMap;
    }
    public CompteRendu(){
        exerciseScoresMap = new HashMap<>();
        score = 0;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getRemarque() {
        return remarque;
    }
    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public HashMap<Evaluable, List<Integer>> getExerciseScoresMap() {
        return exerciseScoresMap;
    }
    public void setExerciseScoresMap(HashMap<Evaluable, List<Integer>> exerciseScoresMap) {
        this.exerciseScoresMap = exerciseScoresMap;
    }

    public void ajouterScore(Evaluable evaluable, int score){
        if (!exerciseScoresMap.containsKey(evaluable)) {
            exerciseScoresMap.put(evaluable, new ArrayList<>());
        }
        exerciseScoresMap.get(evaluable).add(score);
    }



}
//score ikoun frl compte rendu
