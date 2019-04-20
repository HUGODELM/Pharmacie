/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Medecin;
import Pharmacie.metier.Prescription;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author huggy
 */
public class MedecinDAO extends DAO<Medecin> {

    /**
     * permet de lire un un ligne de la table api_medecin
     *
     * @param id identifiant du medecin recherché
     * @return T médecin trouvé
     * @throws SQLException médecin non trouvé
     */
    @Override
    public Medecin read(int id) throws SQLException {
        String req = "SELECT * FROM API_MEDECIN WHERE IDMED=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String mat = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    return new Medecin(id, mat, nom, prenom, tel);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }

    /**
     * Permet de créer une entrée dans la table api_medecin
     *
     * @param obj médecin à créer
     * @return T médecin créé
     * @throws SQLException exception de création
     */
    @Override
    public Medecin create(Medecin obj) throws SQLException {
        String req1 = "INSERT INTO API_MEDECIN(MATRICULE,NOM,PRENOM,TEL) VALUES(?,?,?,?)";
        String req2 = "SELECT * FROM API_MEDECIN WHERE NOM=? AND PRENOM=? AND MATRICULE=? AND TEL=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation médecin, aucune ligne créée");
            } else {
                System.out.println(n + " ligne ajoutée");
            }
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getMatricule());
            pstm2.setString(4, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idmed = rs.getInt(1);
                    obj.setIdmed(idmed);
                    return read(idmed);
                } else {
                    throw new SQLException("erreur de création médecin, record introuvable");
                }
            }
        }

    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la table
     * api_medecin
     *
     * @param obj medecin à mettre à jour
     * @throws SQLException exception mise à jour
     * @return T medecin mis à jour
     */
    @Override
    public Medecin update(Medecin obj) throws SQLException {
        String req = "UPDATE API_MEDECIN SET MATRICULE=?, NOM=?, PRENOM=?, TEL=? WHERE IDMED=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getMatricule());
            pstm.setString(2, obj.getNom());
            pstm.setString(3, obj.getPrenom());
            pstm.setString(4, obj.getTel());
            pstm.setInt(5, obj.getIdmed());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médecin mise à jour");
            }
            return read(obj.getIdmed());
        }
    }

    /**
     * Permet la suppression d'une entrée de la table api_medecin
     *
     * @param obj medecin à effacer
     * @throws SQLException exception d'effacement
     */
    @Override
    public void delete(Medecin obj) throws SQLException {
        String req = "DELETE FROM API_MEDECIN WHERE IDMED=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdmed());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Code inconnu");
            }
        } catch (SQLException e) {
            Scanner sc = new Scanner(System.in);
            String req2 = "DELETE FROM API_PRESCRIPTION WHERE IDMED=?";
            String req3 = "SELECT * FROM API_PRESCRIPTION WHERE IDMED=?";
            try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2); PreparedStatement pstm = dbConnect.prepareStatement(req);
                    PreparedStatement pstm3 = dbConnect.prepareStatement(req3)) {
                pstm3.setInt(1, obj.getIdmed());
                ResultSet rs = pstm3.executeQuery();
                if (rs.next()) {
                    int idpres = rs.getInt("IDPRES");
                    int idmed = rs.getInt("IDMED");
                    int idpat = rs.getInt("IDPAT");
                    String date = rs.getString("DATEPRESCRIPTION");
                    Prescription p = new Prescription(idpres, date, idmed, idpat );
                    System.out.println("Pour supprimer le médicament sélectionner, vous devez supprimer la prescription suivante:\n" + p);
                        pstm2.setInt(1, obj.getIdmed());
                        pstm2.executeUpdate();
                        pstm.setInt(1, obj.getIdmed());
                        pstm.executeUpdate();
                    
                }
            }
        }
    }

}
