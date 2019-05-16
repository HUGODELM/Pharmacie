/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.Observer;
import DesignPatterns.metier.Prescription;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author huggy
 */
public class Medecin extends Subject{
    protected int idmed;
    String matricule,nom,prenom,tel;
    protected Set<Prescription> pres=new HashSet <>();
    public Medecin(){
     //TODO implémenter la mhétode abstraite
    }
    public Medecin(int idmed,String matricule,String nom,String prenom,String tel){
        this.idmed=idmed;
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }

    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        NotifyObserver();
    }

    public Set<Prescription> getPres() {
        return pres;
    }

    public void setPres(Set<Prescription> pres) {
        this.pres = pres;
    }

    @Override
    public String toString() {
        return "idmed: " + idmed + "\nmatricule: " + matricule + "\nnom: " + nom + "\nprenom: " + prenom + "\ntel: " + tel + "\npres: " + pres ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.matricule);
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
        final Medecin other = (Medecin) obj;
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String getNotification() {
        return "Nouveau numéro de téléphone de "+nom+" "+prenom+": "+tel;
    }
    
}
