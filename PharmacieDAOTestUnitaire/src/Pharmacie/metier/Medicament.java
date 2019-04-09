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
public class Medicament {
    protected int IDMEDOC;
    protected String NOM;
    protected String DESCRIPTION;
    protected String REFERENCE;

    /** 
        *Constructeur par défaut
     */

    public Medicament() {

    }

    /**
        *constructeur paramétré
        *@param IDMEDOC identifiant du médicament
        *@param NOM nom du medicament
        *@param DESCRIPTION description du médicament
        *@param REFERENCE référence du médicament 
     */

    public Medicament(int IDMEDOC, String NOM, String DESCRIPTION, String REFERENCE) {
        this.IDMEDOC = IDMEDOC;
        this.NOM = NOM;
        this.DESCRIPTION = DESCRIPTION;
        this.REFERENCE = REFERENCE;
    }

    /**
        *getter de l'identifiant du médicament
        * @return retourne l'identifiant du médicament
     */
    public int getIDMEDOC() {
        return IDMEDOC;
    }
    
    /**
        *setter de l'identifiant du médicament
        *@param IDMEDOC nouvelle valeur de l'identifiant
     */

    public void setIDMEDOC(int IDMEDOC) {
        this.IDMEDOC = IDMEDOC;
    }
    
    /**
        *getter du nom du médicament
        *@return retourne le nom du médicament 
     */

    public String getNOM() {
        return NOM;
    }
    
    /**
        *setter du nom du médicament
        *@param NOM nouveau nom du médicament
     */

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }
    
    /**
        *getter de la description du médicament
        *@return retourne la description du médicament
     */

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
    /**
        *setter de la description du médicament
        *@param DESCRIPTION description du médicament
     */

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
    
    /**
        *getter de la référence du médicament
        *@return retourne la référence du médicament
     */

    public String getREFERENCE() {
        return REFERENCE;
    }
    
    /**
        *setter de la référence du médicament
        *@param REFERENCE nouvelle référence du médicamnet
     */

    public void setREFERENCE(String REFERENCE) {
        this.REFERENCE = REFERENCE;
    }
    
    /**
        *méthode pemettant d'afficher les variables d'instances de la classe de manière structurée 
        *@return retourne la chainde de caractère affichant les différentes variables de la classe
     */

    @Override
    public String toString() {
        return "IDMEDOC:" + IDMEDOC + "\nNOM:" + NOM + "\nDESCRIPTION:" + DESCRIPTION + "\nREFERENCE:" + REFERENCE;
    }

}
