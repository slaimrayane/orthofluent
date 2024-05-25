package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.TypePatient;
import com.orthofluent.orthofluent.models.enumerations.TypeQuestionAnamnese;

import java.io.Serializable;

public class QuestionAnamneseEnfant extends QuestionAnamnese implements Serializable {
    private TypePatient typePatient;

    public QuestionAnamneseEnfant(TypeQuestionAnamnese typeQuestionAnamnese, String enonce) {
        super(typeQuestionAnamnese, enonce);
        this.typePatient = TypePatient.ENFANT;
    }

    public TypePatient getTypePatient() {
        return typePatient;
    }

    public void setTypePatient(TypePatient typePatient) {
        this.typePatient = typePatient;
    }



}
