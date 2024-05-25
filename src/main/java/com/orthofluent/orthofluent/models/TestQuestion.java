package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Capacite;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//nzido une methode qui affiche la liste des question ..win?
public class TestQuestion extends Test implements  Serializable {
    private Set<Question> questionsSet;

    public TestQuestion(String nom, Capacite capacite, Set<Question> questionsSet) {
        super(nom, capacite);
        this.questionsSet = questionsSet;
    }
    public TestQuestion(){
        super();
        questionsSet = new HashSet<>();
    }

    @Override
    public void evaluerTest(String conclusion, String remarque) {
        float totalScore = 0;
        for (Question question : questionsSet) {
            totalScore += question.getNote();
            getCompteRendu().ajouterScore(question, question.getNote());
        }
        getCompteRendu().setScore(totalScore);
        getCompteRendu().setConclusion(conclusion);
        getCompteRendu().setRemarque(remarque);
    }

    public void EvaluerQuestion(Question question,int note) {
        for (Question q : questionsSet){
            if (q.equals(question)){
                q.setNote(note);
            }
        }
    }

    public void ajouterQuestion(Question question){
        questionsSet.add(question);
    }
    public void supprimerQuestion(Question question){
        questionsSet.remove(question);
    }
    public List<Question> getQuestions(){
        return new ArrayList<>(questionsSet);
    }

}
