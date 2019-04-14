/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Medecin;
import java.sql.Connection;
import java.sql.SQLException;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huggy
 */
public class MedecinDAOTest {

    static Connection dbConnect;

    public MedecinDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class MedecinDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idmedoc = 0;
        MedecinDAO instance = new MedecinDAO();
        instance.setConnection(dbConnect);
        Medecin obj = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        Medecin expResult = instance.create(obj);
        idmedoc = expResult.getIdmed();
        Medecin result = instance.read(idmedoc);
        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Téléphones différents", expResult.getTel(), result.getTel());
        assertEquals("id différents", expResult.getIdmed(), result.getIdmed());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of create method, of class MedecinDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Medecin obj = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        MedecinDAO instance = new MedecinDAO();
        instance.setConnection(dbConnect);
        Medecin expResult = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        Medecin result = instance.create(obj);
        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Téléphones différents", expResult.getTel(), result.getTel());
        assertNotEquals("id non généré", expResult.getIdmed(), result.getIdmed());
        int idmedoc = result.getIdmed();
        obj = new Medecin(0, "testMatricule2", "testNom", "testPrenom", "testTel");
        try {
            Medecin result2 = instance.create(obj);
            fail("exception de triplet nom/prenom/tel unique non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
            System.out.println(e);
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class MedecinDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medecin obj = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        MedecinDAO instance = new MedecinDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setMatricule("TestMatricule2");
        obj.setNom("TestNom2");
        obj.setPrenom("testPrenom2");
        obj.setTel("testTel2");
        Medecin expResult = obj;
        Medecin result = instance.update(obj);
        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Téléphones différents", expResult.getTel(), result.getTel());
        Medecin obj2 = new Medecin(0, "testMatricule3", "testNom3", "testPrenom3", "testTel3");
        obj2 = instance.create(obj2);
        Medecin result2 = obj2;
        try {
            obj2.setNom("TestNom2");
            obj2.setPrenom("testPrenom2");
            obj2.setTel("testTel2");
            result = instance.update(obj2);
            fail("exception de triplet nom/prenom/tel unique non déclenchée");
        } catch (SQLException e) {
            System.out.println("erreur sql: " + e);
        }
        instance.delete(obj);
        instance.delete(obj2);
    }

    /**
     * Test of delete method, of class MedecinDAO.
     */
    @Test
    public void testDelete() throws Exception {
       System.out.println("delete");
        Medecin obj = new Medecin(0, "testMatricule", "testNom", "testPrenom", "testTel");
        MedecinDAO instance = new MedecinDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdmed());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        //TODO vérifier qu'on a bien une exception pour la suppression des records parents de clé étrangère
    }

}
