package com.orthofluent.orthofluent.models;

import java.io.Serializable;

public class ProjetTherapeutique implements Serializable {
     private String description;

        public ProjetTherapeutique(String description){
            this.description = description;
        }

        public ProjetTherapeutique(){
        }

        public String getDescription(){
            return description;
        }

        public void setDescription(String description){
            this.description = description;
        }

        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }
            if(obj == this){
                return true;
            }
            if(obj.getClass() != getClass()){
                return false;
            }
            ProjetTherapeutique projetTherapeutique = (ProjetTherapeutique) obj;
            return this.description.equals(projetTherapeutique.getDescription());
        }



}
