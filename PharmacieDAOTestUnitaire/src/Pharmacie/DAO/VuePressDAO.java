/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.VuePress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huggy
 */
public class VuePressDAO extends DAO<VuePress> {

    /**
     * permet de lire un un ligne de la vue VPRES
     *
     * @param idpres identifiant de la prescription lié au record recherché
     * @return T record trouvé
     * @throws SQLException record non trouvé
     */
    @Override
    public VuePress read(int idpres) throws SQLException {
        String req = "SELECT * FROM VPRES WHERE IDPRES=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpres);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idmedoc = rs.getInt("IDMEDOC");
                    String date = rs.getString("DATEPRESCRIPTION");
                    int idmed = rs.getInt("IDMED");
                    int idpat = rs.getInt("IDPAT");
                    int idinfos = rs.getInt("IDINFOS");
                    int quantite = rs.getInt("QUANTITE");
                    String unite = rs.getString("UNITE");
                    String nom = rs.getString("NOM");
                    String desc = rs.getString("DESCRIPTION");
                    String ref = rs.getString("REFERENCE");
                    return new VuePress(idmedoc, idpres, idmed, idpat, idinfos, quantite, date, unite, nom, desc, ref);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }

    @Override
    public VuePress create(VuePress obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VuePress update(VuePress obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VuePress obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
