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

    public void evaluerTest(String Conclusion, String Remarque) {
        for (Question question : questionsSet) {
           getCompteRendu().setScore(getCompteRendu().getScore()+question.getNote());
        }
        getCompteRendu().setConclusion(Conclusion);
        getCompteRendu().setRemarque(Remarque);
    };

    public void EvaluerQuestion(Question question,Boolean valuation){
       for (Question q : questionsSet){
           if (q.equals(question)){
               q.setReponse(valuation);
               q.evaluer();
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
