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

    public boolean supprimerRendezVous( RendezVous rendezVous){
        if (RendezvousSet.contains(rendezVous)) {
            RendezvousSet.remove(rendezVous);
            return true;
        } else {
            return false;
        }
    }


    public Boolean supprimerRendezVous( Atelier rendezVous){
        if (RendezvousSet.contains(rendezVous)) {
            RendezvousSet.remove(rendezVous);
            return true;
        } else {
            return false;
        }
    }
    public Boolean supprimerRendezVous(Consultation rendezVous){
        if (RendezvousSet.contains(rendezVous)) {
            RendezvousSet.remove(rendezVous);
            return true;
        } else {
            return false;
        }
    }

    public Boolean supprimerRendezVous(Suivi rendezVous){
        if (RendezvousSet.contains(rendezVous)) {
            RendezvousSet.remove(rendezVous);
            return true;
        } else {
            return false;
        }
    }
    public TreeSet<RendezVous> getRendezvousSet() {
        return RendezvousSet;
    }
    public void setRendezvousSet(TreeSet<RendezVous> rendezvousSet) {
        RendezvousSet = rendezvousSet;
    }


}
