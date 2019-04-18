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
public class VuePress {

    /**
     * variable d'instance
     */
    private int idmedoc, idpress, idmed, idpat, idinfo, quantite;
    private String date, unite, nom, desc;

    /**
     * constructeur par défaut
     */
    public VuePress() {

    }

    /**
     * contructeur paramétré
     *
     * @param idmedoc identifiant du médicament
     * @param idpress identifiant de la prescription
     * @param idmed identifiant du médecin
     * @param idpat identifiant du patient
     * @param idinfo identifiant de la table info
     * @param quantite quantité de médicament prescrite
     * @param date date de la prescription
     * @param unite unite du médicament
     * @param nom nom du médicament
     * @param desc description du médicament
     */
    public VuePress(int idmedoc, int idpress, int idmed, int idpat, int idinfo, int quantite, String date, String unite, String nom, String desc) {
        this.date = date;
        this.desc = desc;
        this.idinfo = idinfo;
        this.idmed = idmed;
        this.idmedoc = idmedoc;
        this.idpat = idpat;
        this.idpress = idpress;
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
    }

    /**
     * getteur de l'identifiant du médicament
     * @return retourne l'identifiant du médicament
     */
    public int getIdmedoc() {
        return idmedoc;
    }

    /**
     * getteur de l'identifiant de la prescription
     * @return retourne l'identifiant de la prescription
     */
    public int getIdpress() {
        return idpress;
    }

    /**
     * getteur de l'identifiant du médecin 
     * @return retourne l'identifiant du médecin
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * getteur de l'identifiant du patient
     * @return retourne l'identifiant du patient
     */
    public int getIdpat() {
        return idpat;
    }

    /**
     * getteur de l'identifiant de la table info
     * @return retourne l'identifiant de la table info
     */
    public int getIdinfo() {
        return idinfo;
    }

    /**
     * getteur de la quantitée prescrite
     * @return retourne la quantitée prescrite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * getteur de la date de la prescription
     * @return retourne la date de la prescription
     */
    public String getDate() {
        return date;
    }
    /**
     * getteur de l'unité
     * @return retourne l'unité
     */
    public String getUnite() {
        return unite;
    }
    /**
     * getteur du nom du médicament 
     * @return retourne le nom du médicament
     */
    public String getNom() {
        return nom;
    }
    /**
     * getteur de la descritpion 
     * @return retourne la desciption
     */
    public String getDesc() {
        return desc;
    }
     /**
     * méthode renvoyant un string contenant toute les infos de la classe
     *
     * @return string contenant toute les infos de la classe
     */
    @Override
    public String toString() {
        return "idmedoc:" + idmedoc + "\nidpress:" + idpress + "\nidmed:" + idmed + "\nidpat:" + idpat + "\nidinfo:" + idinfo + "\nquantite:" + quantite + "\ndate:" + date + "\nunite:" + unite + "\nnom:" + nom + "\ndesc:" + desc;
    }
    
}
