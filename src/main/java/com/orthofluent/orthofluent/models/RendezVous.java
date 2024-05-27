package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
public abstract class RendezVous implements Comparable<RendezVous>, Serializable {
    private Duration duree;
    private String observation;
    private LocalDateTime date;
    private LocalTime heureDebut;

    // Constructor
    public RendezVous(Duration duree, String observation, LocalDateTime date,LocalTime heureDebut) {
        this.duree = duree;
        this.observation = observation;
        this.date = date;
        this.heureDebut = heureDebut;
    }

    public RendezVous() {
    }

    // Getters and Setters
    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        RendezVous other = (RendezVous) obj;
        LocalDateTime thisDateTime = LocalDateTime.of(this.date.toLocalDate(), this.heureDebut);
        LocalDateTime otherDateTime = LocalDateTime.of(other.date.toLocalDate(), other.heureDebut);
        return thisDateTime.isBefore(otherDateTime.plus(other.duree)) && otherDateTime.isBefore(thisDateTime.plus(this.duree));
    }

    @Override
    public int compareTo(RendezVous other){
        LocalDateTime thisDateTime = LocalDateTime.of(this.date.toLocalDate(), this.heureDebut);
        LocalDateTime otherDateTime = LocalDateTime.of(other.date.toLocalDate(), other.heureDebut);
        LocalDateTime thisEndTime = thisDateTime.plus(this.duree);
        LocalDateTime otherEndTime = otherDateTime.plus(other.duree);
        if (thisDateTime.isBefore(otherDateTime)) {
            if (thisEndTime.isAfter(otherDateTime)) {
                return 0; // Overlap, considered equal
            }
            return -1; // This appointment ends before the other starts
        } else if (thisDateTime.isAfter(otherDateTime)) {
            if (otherEndTime.isAfter(thisDateTime)) {
                return 0; // Overlap, considered equal
            }
            return 1; // This appointment starts after the other ends
        } else {
            return 0; // They start at the same time, considered equal
        }
    }
}



