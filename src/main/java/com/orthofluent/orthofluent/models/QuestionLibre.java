package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;

import java.io.Serializable;


public class QuestionLibre extends Question implements Serializable {
    private String Reponse;

   public QuestionLibre(String enonce, int note) {
    super(enonce, QuestionType.LIBRE,note);
   }
  public QuestionLibre(String enonce) {
    super(enonce, QuestionType.LIBRE);

  }
  public QuestionLibre() {
        setQuestionType(QuestionType.LIBRE);
  }

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String reponse) {
        Reponse = reponse;
    }


}
