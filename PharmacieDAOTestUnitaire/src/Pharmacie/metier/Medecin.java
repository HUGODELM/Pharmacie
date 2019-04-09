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
public class Medecin {
    private int idmed;
    private String matricule,nom,prenom,tel;
    
    /**
     * constructeur par défaut
     */
    public Medecin(){
        
    }
    /**
     * costructeur paramétré
     * @param idmed identifiant du médecin 
     * @param matricule matricule du médecin
     * @param nom nom du médecin 
     * @param prenom prénom du médecin 
     * @param tel numéro de téléphone du médecin
     */
    public Medecin(int idmed, String matricule,String nom,String prenom,String tel){
        this.idmed=idmed;
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }
    /**
     * getter de l'identifiant du médecin 
     * @return retourne l'indentifiant du médecin 
     */
    public int getIdmed() {
        return idmed;
    }
    /**
     * setter de l'identifiant du médecin
     * @param idmed identifiant du médecin  
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }
    /**
     * getter du matricule du médecin 
     * @return retourne le matricule du médecin 
     */
    public String getMatricule() {
        return matricule;
    }
     /**
     * setter du matricule du médecin
     * @param matricule matricule du médecin  
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter du nom du médecin 
     * @return retourne le nom du médecin 
     */
    public String getNom() {
        return nom;
    }
     /**
     * setter du nom du médecin
     * @param nom nom du médecin  
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter du prénom du médecin 
     * @return retourne le prénom du médecin 
     */
    public String getPrenom() {
        return prenom;
    }
     /**
     * setter du prénom du médecin
     * @param prenom prénom du médecin  
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter du numéro de téléphone du médecin 
     * @return retourne le numéro de téléphone du médecin 
     */
    public String getTel() {
        return tel;
    }
     /**
     * setter du numéro de téléphone du médecin
     * @param tel numéro de téléphone du médecin  
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
        return "idmed: " + idmed + "\n matricule: " + matricule + "\n nom: " + nom + "\n prenom: " + prenom + "\n tel: " + tel;
    }
    
}
