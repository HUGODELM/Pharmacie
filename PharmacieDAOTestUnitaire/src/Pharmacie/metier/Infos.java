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
public class Infos {

    /**
     * variable d'instance
     */
    private int idinfos, idmedoc, idpres, quantite;
    private String unite;

    /**
     * constructeur par defaut
     */
    public Infos() {

    }
    /**
     * contructeur paramétré
     * @param idinfos identifiant de la table info
     * @param idmedoc identifiant du médicament
     * @param idpres identifiant de la prescription
     * @param quantite quantité prescrite
     * @param unite  unité du médicament 
     */
    public Infos(int idinfos, int idmedoc,int idpres, int quantite, String unite){
        this.idinfos=idinfos;
        this.idmedoc=idmedoc;
        this.idpres=idpres;
        this.quantite=quantite;
        this.unite=unite;
    }
    /**
     * getteur de l'identifiant de la table infos
     * @return identifiant de la table infos
     */
    public int getIdinfos() {
        return idinfos;
    }
    //TODO javadoc
    public int getIdmedoc() {
        return idmedoc;
    }

    public int getIdpres() {
        return idpres;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }
    
}
