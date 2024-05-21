package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.Thematique;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;


//lazem neqlebha map pour ajouter les patients
public class Atelier extends RendezVous implements Serializable {
    private Set<Integer> numeroDossier;
    // private String thematique;
    private Thematique thematique; // Here i used l'énumération in case m9n3atekch radha string

    public Atelier(String observation, LocalDateTime date,Set<Integer> numeroDossier, Thematique thematique) {
        super(Duration.ofMinutes(60), observation,date);
        this.numeroDossier = numeroDossier;
        this.thematique = thematique;
    }

    public Atelier(){

    }

}
