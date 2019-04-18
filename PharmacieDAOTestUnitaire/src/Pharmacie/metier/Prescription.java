/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.metier;

/**
 *
 * @author huggy
 */
public class Prescription {

    /**
     * variable d'instance
     */
    private int idpres, idmed, idpat;
    private String date;

    /**
     * constructeur par défaut
     */
    public Prescription() {

    }

    /**
     *
     * @param idpres identifiant de la prescription
     * @param idmed identifiant du médecin
     * @param idpat identifiant du patient
     * @param date date de la prescription
     */
    public Prescription(int idpres, int idmed, int idpat, String date) {
        this.idpres = idpres;
        this.idmed = idmed;
        this.idpat = idpat;
        this.date = date;
    }

    /**
     * getteur de l'identifiant de la prescription
     *
     * @return retourne l'identifiant de la prescription
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * getteur de l'identifiant du médecin
     *
     * @return retourne l'identifiant du médecin
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * getteur de l'identifiant du patient
     *
     * @return identifiant du patient
     */
    public int getIdpat() {
        return idpat;
    }

    /**
     * getteur de la date de la prescription
     *
     * @return retourne la date de la prescription
     */
    public String getDate() {
        return date;
    }

    /**
     * setteur de l'identifiant de la prescription
     *
     * @param idpres identifiant de la prescription
     */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    /**
     * setteur de l'identifiant du médecin
     *
     * @param idmed identifiant du médecin
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    /**
     * setteur de l'identifiant du patient
     *
     * @param idpat identifiant du patient
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    /**
     * setteur de la date de la prescription
     *
     * @param date date de la prescription
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * méthode renvoyant un string contenant toute les infos de la classe
     *
     * @return string contenant toute les infos de la classe
     */
    @Override
    public String toString() {
        return "idpres:" + idpres + "\nidmed:" + idmed + "\nidpat:" + idpat + "\ndate:" + date;
    }
}

