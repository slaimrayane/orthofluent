package com.orthofluent.orthofluent.models;

import java.util.List;
import java.util.ArrayList;

public class QuestionLibre extends Question {
  private List<Proposition> propositions = new ArrayList<>();

  public QuestionLibre(String enonce, List<Proposition> propositions) {
    super(enonce);
    this.propositions = propositions;
  }

  public void ajouterQuestion() {

  };

  public void supprimerQuestion() {

  };
}
