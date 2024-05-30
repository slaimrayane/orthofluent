package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Anamnese implements Serializable {
    private Set<QuestionAnamnese> questionsAnamnese;

    // constructor, getters and setters
    public Anamnese(Set<QuestionAnamnese> questionsAnamnese) {
        this.questionsAnamnese = questionsAnamnese;
    }

    public Anamnese() {
        questionsAnamnese= new HashSet<>();
    }

    public Set<QuestionAnamnese> getQuestionsAnamnese() {
        return questionsAnamnese;
    }

    public void setQuestionsAnamnese(Set<QuestionAnamnese> questionsAnamnese) {
        this.questionsAnamnese = questionsAnamnese;
    }

    public void ajouterQuestionAnamnese(QuestionAnamnese questionAnamnese) {
        questionsAnamnese.add(questionAnamnese);
    }

    public void supprimerQuestionAnamnese(QuestionAnamnese questionAnamnese) {
        questionsAnamnese.remove(questionAnamnese);
    }

    public void ajouterQuestionsAnamnese(List<QuestionAnamnese> questionsAnamnese) {
        this.questionsAnamnese.addAll(questionsAnamnese);
    }

    public void supprimerQuestionsAnamnese(List<QuestionAnamnese> questionsAnamnese) {
        this.questionsAnamnese.removeAll(questionsAnamnese);
    }

    public void ajouterReponse(QuestionAnamnese questionAnamnese,String reponse) {
        for (QuestionAnamnese question : questionsAnamnese) {
            if (question.equals(questionAnamnese)) {
                question.setReponse(reponse);
            }
        }
    }

    public void supprimerReponse(QuestionAnamnese questionAnamnese) {
        for (QuestionAnamnese question : questionsAnamnese) {
            if (question.equals(questionAnamnese)) {
                question.setReponse(null);
            }
        }
    }

    public List<QuestionAnamnese> getQuestionsAnamneseList(){
        return new ArrayList<>(questionsAnamnese);
    }

}
