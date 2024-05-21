package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.List;


public class Anamnese implements Serializable {
    private List<QuestionAnamnese> questionAnamnese;

    public Anamnese(List<QuestionAnamnese> questionAnamnese) {
        this.questionAnamnese = questionAnamnese;
    }

}
