package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConsultationEnfant extends Consultation implements Serializable {
    public ConsultationEnfant(String observation, LocalDateTime date, LocalTime heureDebut,String nom, String prenom, String age) {
        super(Duration.ofMinutes(150), observation, date,heureDebut, nom, prenom, age);
    }
    public  ConsultationEnfant(){
        setDuree(Duration.ofMinutes(90));
    }
}
