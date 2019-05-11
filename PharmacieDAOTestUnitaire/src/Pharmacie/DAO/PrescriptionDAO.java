/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Prescription;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huggy
 */
public class PrescriptionDAO extends DAO<Prescription> {
     /**
     permet de lire un un ligne de la table api_prescription
     * @param idpres identifiant du prescription recherché
     * @return T prescription trouvé
     * @throws SQLException prescription non trouvé
     */
    @Override
    public Prescription read(int idpres) throws SQLException {
        String req = "SELECT IDPRES,IDPAT,IDMED,TO_CHAR(DATEPRESCRIPTION,'DD MM YYYY') as \"DATEPRESCRIPTION\" FROM API_PRESCRIPTION WHERE IDPRES=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpres);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idmed = rs.getInt("IDMED");
                    int idpat = rs.getInt("IDPAT");
                    String date = rs.getString("DATEPRESCRIPTION");
                    return new Prescription(idpres, date, idmed, idpat);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }
     /**
    * Permet de créer une entrée dans la table api_prescription
	 * @param obj medicament à créer
         * @return T medicament créé
         * @throws SQLException exception de création
     */
    @Override
    public Prescription create(Prescription obj) throws SQLException {
        String req1 = "INSERT INTO API_PRESCRIPTION(IDMED,IDPAT,DATEPRESCRIPTION) VALUES(?,?,?)";
        String req2 = " SELECT IDPRES FROM API_PRESCRIPTION WHERE IDMED=?  AND IDPAT=? AND DATEPRESCRIPTION=? ";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getIdmed());
            pstm1.setInt(2, obj.getIdpat());
            pstm1.setString(3, obj.getDate());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation prescription, aucune ligne créée");
            } else {
                System.out.println(n + " ligne ajoutée");
            }
            pstm2.setInt(1, obj.getIdmed());
            pstm2.setInt(2, obj.getIdpat());
            pstm2.setString(3, obj.getDate());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idpres = rs.getInt(1);
                    obj.setIdpres(idpres);
                    return read(idpres);
                } else {
                    throw new SQLException("erreur de création prescription, record introuvable");
                }
            }
        }
    }
    /**
     * Permet de mettre à jour les données d'une entrée dans la table api_prescription
	 * @param obj prescription à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T prescription mis à jour
     */
    @Override
    public Prescription update(Prescription obj) throws SQLException {
        String req = "UPDATE API_PRESCRIPTION SET IDMED=?, IDPAT=?, DATEPRESCRIPTION=? WHERE IDPRES=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdmed());
            pstm.setInt(2, obj.getIdpat());
            pstm.setString(3,obj.getDate());
            pstm.setInt(4, obj.getIdpres());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médicament mise à jour");
            }
            return read(obj.getIdpres());
        }
    }
    /**
     * Permet la suppression d'une entrée de la table api_prescription
	 * @param obj prescription à effacer
         * @throws SQLException exception d'effacement
     */
    @Override
    public void delete(Prescription obj) throws SQLException {
        String req = "DELETE FROM API_PRESCRIPTION WHERE IDPRES= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdpres());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client effacée");
            }

        }
    }

}
