package com.orthofluent.orthofluent.models;

import com.orthofluent.orthofluent.models.enumerations.ThematiqueAtelier;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


//lazem neqlebha map pour ajouter les patients
public class Atelier extends RendezVous implements Serializable {
    private Set<Integer> numeroDossier;
    private ThematiqueAtelier thematiqueAtelier; // Here i used l'énumération in case m9n3atekch radha string

    public Atelier(String observation, LocalDateTime date, LocalTime heureDebut, Set<Integer> numeroDossier, ThematiqueAtelier thematiqueAtelier) {
        super(Duration.ofMinutes(60), observation,date,heureDebut);
        this.numeroDossier = numeroDossier;
        this.thematiqueAtelier = thematiqueAtelier;
    }

    public Atelier(){

    }

}
