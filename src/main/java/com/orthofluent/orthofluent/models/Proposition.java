package com.orthofluent.orthofluent.models;

public class Proposition {
    private String enonce;
    private boolean correcte;
    
    public Proposition(String enonce, boolean correcte) {
        this.enonce = enonce;
        this.correcte = correcte;
    }
    
    public String getEnonce() {
        return enonce;
    }
    
    public boolean isCorrecte() {
        return correcte;
    }
    
    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
    
    public void setCorrecte(boolean correcte) {
        this.correcte = correcte;
    }
}