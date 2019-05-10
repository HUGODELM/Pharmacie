/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

/**
 *
 * @author huggy
 */
public class Prescription {
    //TODO doit inserer la table info pour vérifier qu'il y a bien des médicament liés à la prescritpion
    protected int idpres, idmed, idpat;
    protected String date;
    private Prescription(PresBuilder pb){
        this.idpres=pb.idpres;
        this.idmed=pb.idmed;
        this.idpat=pb.idpat;
        this.date=pb.date;
    }

    public int getIdpres() {
        return idpres;
    }

    public int getIdmed() {
        return idmed;
    }

    public int getIdpat() {
        return idpat;
    }

    public String getDate() {
        return date;
    }
    
    public static class PresBuilder {
        protected int idpres, idmed, idpat;
        protected String date;

        public void setIdpres(int idpres) {
            this.idpres = idpres;
        }

        public void setIdmed(int idmed) {
            this.idmed = idmed;
        }

        public void setIdpat(int idpat) {
            this.idpat = idpat;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public Prescription Build() throws Exception{
            return new Prescription(this);
        }
    }
}
