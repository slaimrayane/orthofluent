package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class RendezVous implements Comparable<RendezVous>, Serializable {
    private Duration duree;
    private String observation;
    private LocalDateTime date;

    // Constructor
    public RendezVous(Duration duree, String observation, LocalDateTime date) {
        this.duree = duree;
        this.observation = observation;
        this.date = date;
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

    //for the moment just compare with object of the same type 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        RendezVous other = (RendezVous) obj;
        return date.isBefore(other.date.plus(other.duree)) && other.date.isBefore(date.plus(duree));
    }

    @Override
    public int compareTo(RendezVous other){
        LocalDateTime thisEndTime = this.date.plus(this.duree);
        LocalDateTime otherEndTime = other.date.plus(other.duree);
        if (this.date.isBefore(other.date)) {
            if (thisEndTime.isAfter(other.date)) {
                return 0; // Overlap, considered equal
            }
            return -1; // This appointment ends before the other starts
        } else if (this.date.isAfter(other.date)) {
            if (otherEndTime.isAfter(this.date)) {
                return 0; // Overlap, considered equal
            }
            return 1; // This appointment starts after the other ends
        } else {
            return 0; // They start at the same time, considered equal
        }
    }
}



