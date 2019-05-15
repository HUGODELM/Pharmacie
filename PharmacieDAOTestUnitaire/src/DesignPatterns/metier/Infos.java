/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.Objects;

/**
 *
 * @author hugo.delmarche
 */
public class Infos {
        protected int idinfos,quantite;
        protected String unite; 
        protected Medicament m;
        public Infos(int idinfos, int quantite,String unite ,Medicament m){
            this.idinfos=idinfos;
            this.quantite=quantite;
            this.unite=unite;
            this.m=m;
        }

    public int getIdinfos() {
        return idinfos;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Medicament getM() {
        return m;
    }

    public void setM(Medicament m) {
        this.m = m;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.quantite;
        hash = 89 * hash + Objects.hashCode(this.unite);
        hash = 89 * hash + Objects.hashCode(this.m);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Infos other = (Infos) obj;
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!Objects.equals(this.unite, other.unite)) {
            return false;
        }
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "idinfos: " + idinfos + "\nquantite: " + quantite + "\nunite: " + unite + "\nm: " + m + '}';
    }
        
}
