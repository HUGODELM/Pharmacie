/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

//import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author hugo.delmarche
 */
public class Medicament {
    protected int idmedoc;
    protected String nom,desc,ref;
    //protected Set<Infos> info=new HashSet<>();
    public Medicament(){
        
    }
    public Medicament(int idmedoc, String nom, String desc, String ref){
        this.idmedoc=idmedoc;
        this.nom=nom;
        this.desc=desc;
        this.ref=ref;
    }

    public int getIdmedoc() {
        return idmedoc;
    }

    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

   /* public Set<Infos> getInfo() {
        return info;
    }

    public void setInfo(Set<Infos> info) {
        this.info = info;
    }*/

    @Override
    public String toString() {
        return "idmedoc: " + idmedoc + "\nnom: " + nom + "\ndesc: " + desc + "\nref: " + ref;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ref);
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
        final Medicament other = (Medicament) obj;
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        return true;
    }
    
}
