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
   // @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int id = 0;
        MedecinDAO instance = new MedecinDAO();
        Medecin expResult = null;
        Medecin result = instance.read(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MedecinDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
       Medecin obj = new Medecin(0, "testMatricule","testNom", "testPrenom", "testTel");
        MedecinDAO instance = new MedecinDAO();
        instance.setConnection(dbConnect);
        Medecin expResult = new Medecin(0, "testMatricule","testNom", "testPrenom", "testTel");
        Medecin result = instance.create(obj);
        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Prénoms différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Téléphones différents", expResult.getTel(), result.getTel());
        assertNotEquals("id non généré", expResult.getIdmed(), result.getIdmed());
        int idmedoc = result.getIdmed();
        obj = new Medecin(0, "testMatricule2","testNom", "testPrenom", "testTel");
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
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medecin obj = null;
        MedecinDAO instance = new MedecinDAO();
        Medecin expResult = null;
        Medecin result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MedecinDAO.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medecin obj = null;
        MedecinDAO instance = new MedecinDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
