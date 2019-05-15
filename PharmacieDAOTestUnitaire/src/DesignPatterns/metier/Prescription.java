/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author huggy
 */
public class Prescription {

    protected int idpres;
    protected Patient p;
    protected Medecin m;
    protected String date;
    protected Set<Infos> info=new HashSet<>(); 
    public Prescription(){
        
    }
    public Prescription(int idpres, Patient p, Medecin m, String date){
        this.idpres=idpres;
        this.date=date;
        this.m=m;
        this.p=p;
    }

    public int getIdpres() {
        return idpres;
    }

    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Medecin getM() {
        return m;
    }

    public void setM(Medecin m) {
        this.m = m;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    public void setInfo(Set<Infos> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return"idpres: " + idpres + "\np: " + p + "\nm: " + m + "\ndate: " + date + "\ninfo: " + info + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.info);
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
        final Prescription other = (Prescription) obj;
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        return true;
    }
    
    
}
