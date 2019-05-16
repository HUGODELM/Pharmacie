/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Patient;
import Pharmacie.metier.Prescription;
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
public class PatientDAO extends DAO<Patient> {

    /**
     * permet de lire un un ligne de la table api_patient
     *
     * @param idpat identifiant du patient recherché
     * @return T patient trouvé
     * @throws SQLException patient non trouvé
     */
    @Override
    public Patient read(int idpat) throws SQLException {
        String req = "SELECT * FROM API_PATIENT WHERE IDPAT=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpat);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    return new Patient(idpat, nom, prenom, tel);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }

    /**
     * Permet de créer une entrée dans la table api_patient
     *
     * @param obj medicament à créer
     * @return T medicament créé
     * @throws SQLException exception de création
     */
    @Override
    public Patient create(Patient obj) throws SQLException {
        String req1 = "INSERT INTO API_PATIENT(NOM,PRENOM,TEL) VALUES(?,?,?)";
        String req2 = " SELECT IDPAT FROM API_PATIENT WHERE NOM=?  AND PRENOM=? AND TEL=? ";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getPrenom());
            pstm1.setString(3, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation patient, aucune ligne créée");
            } else {
                System.out.println(n + " ligne ajoutée");
            }
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idpat = rs.getInt(1);
                    obj.setIdpat(idpat);
                    return read(idpat);
                } else {
                    throw new SQLException("erreur de création prescription, record introuvable");
                }
            }
        }
    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la table
     * api_patient
     *
     * @param obj patient à mettre à jour
     * @throws SQLException exception mise à jour
     * @return T patient mis à jour
     */
    @Override
    public Patient update(Patient obj) throws SQLException {
        String req = "UPDATE API_PATIENT SET NOM=?, PRENOM=?, TEL=? WHERE IDPAT=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getNom());
            pstm.setString(2, obj.getPrenom());
            pstm.setString(3, obj.getTel());
            pstm.setInt(4, obj.getIdpat());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médicament mise à jour");
            }
            return read(obj.getIdpat());
        }
    }

    /**
     * Permet la suppression d'une entrée de la table api_patient
     *
     * @param obj patient à effacer
     * @throws SQLException exception d'effacement
     */
    @Override
    public void delete(Patient obj) throws SQLException {
        String req = "DELETE FROM API_PATIENT WHERE IDPAT=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdpat());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Code inconnu");
            }
        } catch (SQLException e) {
            Scanner sc = new Scanner(System.in);
            String req2 = "DELETE FROM API_PRESCRIPTION WHERE IDPAT=?";
            String req3 = "SELECT * FROM API_PRESCRIPTION WHERE IDPAT=?";
            try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2); PreparedStatement pstm = dbConnect.prepareStatement(req);
                    PreparedStatement pstm3 = dbConnect.prepareStatement(req3)) {
                pstm3.setInt(1, obj.getIdpat());
                ResultSet rs = pstm3.executeQuery();
                if (rs.next()) {
                    int idpres = rs.getInt("IDPRES");
                    int idmed = rs.getInt("IDMED");
                    int idpat = rs.getInt("IDPAT");
                    String date = rs.getString("DATEPRESCRIPTION");
                    Prescription p = new Prescription(idpres, date, idmed, idpat);
                    System.out.println("Pour supprimer le patient sélectionner, vous devez supprimer la prescription suivante:\n" + p);
                    pstm2.setInt(1, obj.getIdpat());
                    pstm2.executeUpdate();
                    pstm.setInt(1, obj.getIdpat());
                    pstm.executeUpdate();

                }
            }
        }
    }

    /**
     * recherche large sur le nom d'un médecin
     * @param rech nom du médecin recherché
     * @return liste contenant les id des médecins
     * @throws SQLException 
     */
    public List search(String rech) throws SQLException {
        String query1 = "SELECT * FROM API_PATIENT WHERE  NOM LIKE ?";
        List<Integer> idTab = new ArrayList();
        boolean trouver = false;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
            pstm.setString(1, "%" + rech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    trouver = true;
                    int id = rs.getInt("IDPRES");
                    idTab.add(id);

                }
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
        if (!trouver) {
            System.out.println("Aucune prescription trouvée...");
            idTab.add(0);
        }
        return idTab;
    }

}
