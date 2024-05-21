package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class ConsultationEnfant extends Consultation implements Serializable {
    public ConsultationEnfant( String observation, LocalDateTime date,String nom, String prenom, String age) {
        super(Duration.ofMinutes(90), observation, date, nom, prenom, age);
    }
    public  ConsultationEnfant(){
        setDuree(Duration.ofMinutes(90));
    }
}
