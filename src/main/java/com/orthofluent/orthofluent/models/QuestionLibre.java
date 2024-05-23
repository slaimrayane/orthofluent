package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.QuestionType;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class QuestionLibre extends Question implements Serializable {
  private List<Proposition> propositionsList ;

  public QuestionLibre(String enonce, List<Proposition> propositionsList) {
    super(enonce, QuestionType.LIBRE);
    this.propositionsList = propositionsList;
  }
  public QuestionLibre() {
        setQuestionType(QuestionType.LIBRE);
        propositionsList = new ArrayList<>();
  }

  public void setPropositionsList(List<Proposition> propositionsList) {
        this.propositionsList = propositionsList;
  }

  public List<Proposition> getPropositionsList() {
        return propositionsList;
  }

  public void ajouterProposition(Proposition proposition) {
        propositionsList.add(proposition);
  }
  public void supprimerProposition(Proposition proposition) {
        propositionsList.remove(proposition);
  }


}
