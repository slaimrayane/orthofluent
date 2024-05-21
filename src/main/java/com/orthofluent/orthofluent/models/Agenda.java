package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.TreeSet;

public class Agenda implements Serializable {
    private TreeSet<RendezVous> RendezvousSet;

    public Agenda(){
        RendezvousSet = new TreeSet<>();
    }

    public boolean ajouterRendezVous( RendezVous rendezVous){
        if (RendezvousSet.contains(rendezVous)) {
            return false;
        } else {
            RendezvousSet.add(rendezVous);
            return true;
        }
    }
}
