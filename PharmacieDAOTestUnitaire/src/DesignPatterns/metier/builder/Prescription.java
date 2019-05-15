/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

import DesignPatterns.metier.Infos;
import DesignPatterns.metier.Medecin;
import DesignPatterns.metier.Patient;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
//en ce qui concerne le add infos, code inspirré de celui de dorian

/**
 *
 * @author hugo.delmarche
 */
public class Prescription {

    protected int idpres;
    protected Patient p;
    protected Medecin m;
    protected String date;
    protected Set<Infos> info = new HashSet<>();

    private Prescription(PrescriptionBuilder pb) {
        this.idpres=pb.idpres;
        this.date=pb.date;
        this.info=pb.info;
        this.m=pb.m;
        this.p=pb.p;
    }

    public int getIdpres() {
        return idpres;
    }

    public Patient getP() {
        return p;
    }

    public Medecin getM() {
        return m;
    }

    public String getDate() {
        return date;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.info);
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
    public static class PrescriptionBuilder {
        protected int idpres;
        protected Patient p;
        protected Medecin m;
        protected String date;
        protected Set<Infos> info = new HashSet<>();

        public PrescriptionBuilder setIdpres(int idpres) {
            this.idpres = idpres;
            return this;
        }

        public PrescriptionBuilder setP(Patient p) {
            this.p = p;
            return this;
        }

        public PrescriptionBuilder setM(Medecin m) {
            this.m = m;
            return this;
        }

        public PrescriptionBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public PrescriptionBuilder AddInfo(Infos infor) {
            info.add(infor);
            return this;
        }
        public Prescription Build() throws Exception{
            if(m==null || p==null || info==null){
                throw new Exception("informations de construction incomplètes");
            }
            return new Prescription(this);
        } 
    }

    @Override
    public String toString() {
        return "idpres: " + idpres + "\np: " + p + "\nm: " + m + "\ndate: " + date + "\ninfo: " + info;
    }
    
}
