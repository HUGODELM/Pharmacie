/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;


import Pharmacie.metier.VuePress;
import java.sql.Connection;
import java.sql.SQLException;
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
public class VuePressDAOTest {
     static Connection dbConnect;
    public VuePressDAOTest() {
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
     * Test of read method, of class VuePressDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idpres = 0;
        VuePressDAO instance = new VuePressDAO();
        instance.setConnection(dbConnect);
        VuePress obj = new VuePress (0,0,0,0,0,0,"02/3/02", "testunite","testnom","testdes","testdesc");
        VuePress expResult = instance.create(obj);
        VuePress result = instance.read(0);
        assertEquals("idpress différents", expResult.getIdpress(), result.getIdpress());
        assertEquals("idmedoc différents", expResult.getIdmedoc(), result.getIdmedoc());
        assertEquals("idinfos différents", expResult.getIdinfo(), result.getIdinfo());
        assertEquals("idpat différents", expResult.getIdpat(), result.getIdpat());
        assertEquals("idmed différents", expResult.getIdmed(), result.getIdmed());
        assertEquals("date différentes", expResult.getDate(), result.getDate());
        assertEquals("quantite différentes", expResult.getQuantite(), result.getQuantite());
        assertEquals("unite différents", expResult.getUnite(), result.getUnite());
        assertEquals("noms différents", expResult.getNom(), result.getNom());
        assertEquals("descriptions différentes", expResult.getDesc(), result.getDesc());
        assertEquals("références différentes", trim(expResult.getRef()), trim(result.getRef()));
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of create method, of class VuePressDAO.
     */
   // @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        VuePress expResult = null;
        VuePress result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class VuePressDAO.
     */
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        VuePress expResult = null;
        VuePress result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class VuePressDAO.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        VuePress obj = null;
        VuePressDAO instance = new VuePressDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
