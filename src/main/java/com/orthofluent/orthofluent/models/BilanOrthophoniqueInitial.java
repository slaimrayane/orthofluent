package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;

public class BilanOrthophoniqueInitial extends BilanOrthophonique implements Serializable {
    private Anamnese anamnese;

    public BilanOrthophoniqueInitial(EpreuveClinique epreuveClinique, Diagnostique diagnostique, ProjetTherapeutique projetTherapeutique,Anamnese anamnese){
        super(epreuveClinique, diagnostique, projetTherapeutique);
        this.anamnese = anamnese;
    }

    public BilanOrthophoniqueInitial(){
    }

    public Anamnese getAnamnese(){
        return this.anamnese;
    }

    public void setAnamnese(Anamnese anamnese){
        this.anamnese = anamnese;
    }
    public List<QuestionAnamnese> getQuestionAnamneseList(){
        return anamnese.getQuestionsAnamneseList();
    }

}
