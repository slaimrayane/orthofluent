package com.orthofluent.orthofluent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    public List<Atelier> getAtelierList(){
        List<Atelier> atelierList = new ArrayList<>();
        for (RendezVous rendezVous : RendezvousSet) {
            if (rendezVous instanceof Atelier) {
                atelierList.add((Atelier) rendezVous);
            }
        }
        return atelierList;
    }
    public List<Consultation> getConsultationList(){
        List<Consultation> consultationList = new ArrayList<>();
        for (RendezVous rendezVous : RendezvousSet) {
            if (rendezVous instanceof Consultation) {
                consultationList.add((Consultation) rendezVous);
            }
        }
        return consultationList;
    }
    public List<Suivi> getSuiviList(){
        List<Suivi> suiviList = new ArrayList<>();
        for (RendezVous rendezVous : RendezvousSet) {
            if (rendezVous instanceof Suivi) {
                suiviList.add((Suivi) rendezVous);
            }
        }
        return suiviList;
    }


}
