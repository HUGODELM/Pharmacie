/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;


//import java.util.HashSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author hugo.delmarche
 */
public class Patient {
    protected int idpat;
    protected String nom,prenom,tel;
    protected Set<Prescription> pres=new HashSet <>();
    public Patient(){
        
    }
    public Patient(int idpat,String nom,String prenom,String tel){
        this.idpat=idpat;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }

    public int getIdpat() {
        return idpat;
    }

    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Prescription> getPres() {
        return pres;
    }

    public void setPres(Set<Prescription> pres) {
        this.pres = pres;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.prenom);
        hash = 67 * hash + Objects.hashCode(this.tel);
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
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "idpat: " + idpat + "\nnom: " + nom + "\nprenom: " + prenom + "\ntel: " + tel ;
    }
    
}
