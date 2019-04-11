/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.metier.Medicament;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.trim;
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
public class MedicamentDAOTest {

    static Connection dbConnect;

    public MedicamentDAOTest() {
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
     * Test of read method, of class MedicamentDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idmedoc = 0;
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        Medicament expResult = instance.create(obj);
        idmedoc = expResult.getIDMEDOC();
        Medicament result = instance.read(idmedoc);
        assertEquals("noms différents", expResult.getNOM(), result.getNOM());
        assertEquals("descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertEquals("références différentes", trim(expResult.getREFERENCE()), trim(result.getREFERENCE()));
        assertEquals("id différents", expResult.getIDMEDOC(), result.getIDMEDOC());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of create method, of class MedicamentDAO.
     *
     * @throws java.lang.Exception
     */
    //TODO à finir 
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Medicament obj = new Medicament(0, "testNom", "testDesc", "testRef");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        Medicament expResult = new Medicament(0, "testNom", "testDesc", "testRef");
        Medicament result = instance.create(obj);
        assertEquals("Noms différents", expResult.getNOM(), result.getNOM());
        assertEquals("Descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertEquals("Descriptions différentes", trim(expResult.getREFERENCE()), trim(result.getREFERENCE()));
        assertNotEquals("id non généré", expResult.getIDMEDOC(), result.getIDMEDOC());
        int idmedoc = result.getIDMEDOC();
        obj = new Medicament(0, "testNom2", "testDesc2", "testRef");
        try {
            Medicament result2 = instance.create(obj);
            fail("exception de référence unique non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medicament obj = null;
        MedicamentDAO instance = new MedicamentDAO();
        Medicament expResult = null;
        Medicament result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medicament obj = null;
        MedicamentDAO instance = new MedicamentDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class MedicamentDAO.
     */
    @Test
    public void testSearch() throws Exception {
        System.out.println("search");
        String rech = "";
        MedicamentDAO instance = new MedicamentDAO();
        List expResult = null;
        List result = instance.search(rech);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
