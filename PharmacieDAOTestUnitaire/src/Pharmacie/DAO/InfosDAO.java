/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Infos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huggy
 */
public class InfosDAO extends DAO<Infos>{
    
    /**
     * permet de lire un un ligne de la table api_infos
     * @param id identifiant de du médicament recherché
     * @return T record trouvé
     * @throws SQLException record non trouvé 
     */
    @Override
    public Infos read(int id) throws SQLException {
        String req = "SELECT * FROM API_MEDICAMENT WHERE IDMEDOC=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idmedoc = rs.getInt("IDMEDOC");
                    int idpres = rs.getInt("IDPRES");
                    int quantite = rs.getInt("QUANTITE");
                    String unite = rs.getString("UNITE");
                    return new Infos(id, idmedoc, idpres, quantite, unite);
                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }
     /**
	 * Permet de créer une entrée dans la table api_infos
	 * @param obj record à créer
         * @return T record créé
         * @throws SQLException exception de création
	 */
    @Override
    public Infos create(Infos obj) throws SQLException {
        String req1 = "INSERT INTO API_INFOS(IDMEDOC,IDPRES,QUANTITE,UNITE) VALUES(?,?,?,?)";
        String req2 = " SELECT IDINFOS FROM API_INFOS WHERE IDMEDOC=?  AND IDPRES=? AND QUANTITE=? AND UNITE=? ";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getIdmedoc());
            pstm1.setInt(2, obj.getIdpres());
            pstm1.setInt(3, obj.getQuantite());
            pstm1.setString(4, obj.getUnite());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation médicament, aucune ligne créée");
            }
            else{
                System.out.println(n+" ligne ajoutée");
            }
            pstm2.setInt(1, obj.getIdmedoc());
            pstm2.setInt(2, obj.getIdpres());
            pstm2.setInt(3, obj.getQuantite());
            pstm2.setString(4, obj.getUnite());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idinfos = rs.getInt(1);
                    obj.setIdinfos(idinfos);
                    return read(idinfos);
                } else {
                    throw new SQLException("erreur de création client, record introuvable");
                }
            }
        }
    }

    @Override
    public Infos update(Infos obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Infos obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
