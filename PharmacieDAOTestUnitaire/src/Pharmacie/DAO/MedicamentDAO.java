/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Medicament;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huggy
 */
public class MedicamentDAO extends DAO<Medicament> {
    /**
     * permet de lire un un ligne de la table api_medicament
     * @param id identifiant de du médicament recherché
     * @return T medicament trouvé
     * @throws SQLException medicament non trouvé 
     */
    @Override
    public Medicament read(int id) throws SQLException {
        String req = "SELECT * FROM API_MEDICAMENT WHERE IDMEDOC=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String desc = rs.getString("DESCRIPTION");
                    String ref = rs.getString("REFERENCE");
                    return new Medicament(id, nom, desc, ref);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }
    /**
	 * Permet de créer une entrée dans la table api_médicament
	 * @param obj medicament à créer
         * @return T medicament créé
         * @throws SQLException exception de création
	 */

    @Override
    public Medicament create(Medicament obj) throws SQLException {
        String req1 = "INSERT INTO API_MEDICAMENT(NOM,DESCRIPTION,REFERENCE) VALUES(?,?,?)";
        String req2 = " SELECT IDMEDOC FROM API_MEDICAMENT WHERE NOM=?  AND DESCRIPTION=? AND TRIM(REFERENCE)=? ";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNOM());
            pstm1.setString(2, obj.getDESCRIPTION());
            pstm1.setString(3, obj.getREFERENCE());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation médicament, aucune ligne créée");
            }
            else{
                System.out.println(n+" ligne ajoutée");
            }
            pstm2.setString(1, obj.getNOM());
            pstm2.setString(2, obj.getDESCRIPTION());
            pstm2.setString(3, obj.getREFERENCE());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idmed = rs.getInt(1);
                    obj.setIDMEDOC(idmed);
                    return read(idmed);
                } else {
                    throw new SQLException("erreur de création client, record introuvable");
                }
            }
        }
    }
    /**
	 * Permet de mettre à jour les données d'une entrée dans la table api_medicament
	 * @param obj medicament à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T medicament mis à jour
	 */
    @Override
    public Medicament update(Medicament obj) throws SQLException {
        String req = "UPDATE API_MEDICAMENT SET NOM=?, DESCRIPTION=?, REFERENCE=? WHERE IDMEDOC=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getNOM());
            pstm.setString(2, obj.getDESCRIPTION());
            pstm.setString(3, obj.getREFERENCE());
            pstm.setInt(4, obj.getIDMEDOC());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médicament mise à jour");
            }
            return read(obj.getIDMEDOC());
        }
    }
    /**
	 * Permet la suppression d'une entrée de la table api_medicament
	 * @param obj medicament à effacer
         * @throws SQLException exception d'effacement
	 */
    @Override
    public void delete(Medicament obj) throws SQLException {
        String req = "DELETE FROM API_MEDICAMENT WHERE IDMEDOC=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIDMEDOC());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Code inconnu");
            }
        } catch (SQLException e) {
            Scanner sc = new Scanner(System.in);
            String req2 = "DELETE FROM API_INFOS WHERE IDMEDOC=?";
            String req3 = "SELECT * FROM API_INFOS WHERE IDMEDOC=?";
            try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2); PreparedStatement pstm = dbConnect.prepareStatement(req);
                    PreparedStatement pstm3 = dbConnect.prepareStatement(req3)) {
                pstm3.setInt(1, obj.getIDMEDOC());
                ResultSet rs = pstm3.executeQuery();
                if (rs.next()) {
                    int idinfo = rs.getInt("IDINFOS");
                    int idpres = rs.getInt("IDPRES");
                    int idmed = rs.getInt("IDMEDOC");
                    String q = rs.getString("QUANTITE");
                    String unite = rs.getString("UNITE");
                    System.out.println("Pour supprimer le médicament sélectionner, vous devez supprimer la prescription suivante:");
                    System.out.println("idinfos: "+idinfo+"\nidpres: "+idpres+"\nidmedoc: "+idmed+"\nquantite: "+q+"\nunite: "+unite);
                    System.out.println("Pour accepter la suppresion tapez 0, pour annuler taper n'importe quelle autre chiffre");
                    int choix = sc.nextInt();
                    if (choix == 0) {
                        pstm2.setInt(1, obj.getIDMEDOC());
                        pstm2.executeUpdate();
                        pstm.setInt(1, obj.getIDMEDOC());
                        pstm.executeUpdate();
                    }
                    
                }
            }
        }
    }
    /**
     * 
     * @param rech mot clé sur lequel se base la recherche
     * @return retourne l'arraylist contenant les objet trouvé par la recherche
     * @throws SQLException exception du like
     */
    public List search(String rech) throws SQLException {
        String query1 = "SELECT * FROM API_MEDICAMENT WHERE DESCRIPTION LIKE ?";
        List<Integer> idTab=new ArrayList();
        boolean trouver = false;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
            pstm.setString(1, "%" + rech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    trouver = true;
                    int id = rs.getInt("IDMEDOC");
                    idTab.add(id);
                    
                }
            }
        }
        catch(SQLException e){
            System.out.println("erreur "+e);
        }
        if(!trouver){
            System.out.println("Aucun médicament trouvé...");
            idTab.add(0);
        }
            return idTab;
    }

}
