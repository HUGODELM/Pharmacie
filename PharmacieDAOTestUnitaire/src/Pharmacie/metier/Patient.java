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
public class Patient {
    private int idpat;
    private String nom,prenom,tel;
    
    /**
     * constructeur par défaut
     */
    public Patient(){
        
    }
    /**
     * 
     * @param idpat identifiant du patient 
     * @param nom du patient 
     * @param prenom prénom du patient 
     * @param tel numéro de téléphone du patient
     */
    public Patient (int idpat,String nom,String prenom,String tel){
        this.idpat=idpat;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }
    /**
     * getter de l'identifiant du patient 
     * @return retourne l'indentifiant du patient 
     */
    public int getIdpat() {
        return idpat;
    }
    /**
     * setter de l'identifiant du patient
     * @param idpat identifiant du patient  
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }
     /**
     * getter du nom du patient 
     * @return retourne le nom du patient 
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter du nom du patient
     * @param nom nom du patient  
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter du prénom du patient 
     * @return retourne le prénom du patient 
     */
    public String getPrenom() {
        return prenom;
    }
     /**
     * setter du prénom du patient
     * @param prenom prénom du patient  
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter du numéro de téléphone du patient 
     * @return retourne le numéro de téléphone du patient 
     */
    public String getTel() {
        return tel;
    }
    /**
     * setter du numéro de téléphone du patient
     * @param tel numéro de téléphone du patient  
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * méthode pemettant d'afficher les variables d'instances de la classe de
     * manière structurée
     *
     * @return retourne la chainde de caractère affichant les différentes
     * variables de la classe
     */
    @Override
    public String toString() {
        return "idpat: " + idpat + "\n nom: " + nom + "\n prenom: " + prenom + "\n tel: " + tel;
    }
    
}
