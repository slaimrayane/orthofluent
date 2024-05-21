package com.orthofluent.orthofluent.services;

import com.orthofluent.orthofluent.models.Orthophoniste;

public class DataManager {
    private static DataManager instance;
    private Orthophoniste orthophoniste;

    private DataManager() {
        // Private constructor to prevent instantiation
    }
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void setOrthophoniste(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }

    public Orthophoniste getOrthophoniste() {
        return orthophoniste;
    }
}
